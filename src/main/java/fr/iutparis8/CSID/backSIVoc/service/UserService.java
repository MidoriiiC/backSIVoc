package fr.iutparis8.CSID.backSIVoc.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.domain.UserEntity;
import fr.iutparis8.CSID.backSIVoc.mapper.UserMapper;
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
	
	public List<User> getAllUsers() {
		List<UserEntity> listUserEntity = this.userR.findAll();
		List<User> listE = UserMapper.listUserEntityToListUser(listUserEntity);
		return listE;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username);
		UserEntity userEntity = userEntityR.findOneByUsername(username);
		return userEntity;
	}
	
	public User createUserWithAuthority(User user) {
		UserEntity userEntity = UserMapper.userToUserEntity(user);		
		UserEntity retour = userR.save(userEntity);
		user = UserMapper.userEntityToUser(retour);
		return user;
	}
	
	public void delete(Integer id) {
        if(this.userEntityR.existsById(id)) {
            this.userEntityR.deleteById(id);
        }
    }
	
	public User getUserById(Integer id) {
		return UserMapper.userEntityToUser(this.userR.getOne(id));
	}
	public User modify(User user) {
		UserEntity userModified = this.userEntityR.save(UserMapper.userToUserEntity((user)));
		return UserMapper.userEntityToUser(userModified);
	}
}
