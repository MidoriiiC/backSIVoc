package fr.iutparis8.CSID.backSIVoc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.configuration.SecurityConfiguration;
import fr.iutparis8.CSID.backSIVoc.domain.UserEntity;
import fr.iutparis8.CSID.backSIVoc.mapper.UserMapper;
import fr.iutparis8.CSID.backSIVoc.model.BlocPassword;
import fr.iutparis8.CSID.backSIVoc.model.User;
import fr.iutparis8.CSID.backSIVoc.repository.UserEntityRepository;
import fr.iutparis8.CSID.backSIVoc.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private UserRepository userR;
	private UserEntityRepository userEntityR;

	@Autowired
	public UserService(UserRepository userR, UserEntityRepository userEntityR) {
		this.userR = userR;
		this.userEntityR=userEntityR;
	}
	
	public User createUser(User user) {
		UserEntity userEntity = UserMapper.userToUserEntity(user);
		UserEntity retour = userR.save(userEntity);
		user = UserMapper.userEntityToUser(retour);
		return user;
	}
	
	public List<User> getAllUsers() {
		List<UserEntity> listUserEntity = this.userR.findAll();
		List<User> listE = UserMapper.listUserEntityToListUser(listUserEntity);
		return listE;
	}
	

	public int updatePassword(BlocPassword blocPassword, String utilisateur){  //TODO ne marche pas, erreur SQL engendrée

		String oldPassword = blocPassword.getOldPassword();
		String newPassword = blocPassword.getNewPassword();
		Connection conn;
		try {
			conn = SecurityConfiguration.getDataSource().getConnection(utilisateur, oldPassword);
			if (conn.isValid(0)) {
				SecurityConfiguration.jdbcUserDetailsManager().changePassword(oldPassword, newPassword);
				return 1; // goodConnection
			}
		} catch (SQLException sqlexc) {
			System.out.println(sqlexc + " " + sqlexc.getCause() + " " + sqlexc.getMessage() + " " + sqlexc.getSQLState());
			return 2;
		}

		return 0;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username);
		UserEntity userEntity = userEntityR.findOneByUsername(username);
		return userEntity;
	}
	
	public User createUserWithAuthority(User user) {
		if(user.getName().equals("admin"))
			user.setAuthority("administrateur");
		if(user.getName().equals("modo"))
			user.setAuthority("modérateur");
		if(user.getName().equals("benev"))
			user.setAuthority("bénévole");

		UserEntity userEntity = UserMapper.userToUserEntity(user);		
		UserEntity retour = userR.save(userEntity);
		user = UserMapper.userEntityToUser(retour);
		return user;
	}
}
