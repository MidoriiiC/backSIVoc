package fr.iutparis8.CSID.backSIVoc.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.domain.UserEntity;
import fr.iutparis8.CSID.backSIVoc.dto.UserDTO;
import fr.iutparis8.CSID.backSIVoc.mapper.UserMapper;
import fr.iutparis8.CSID.backSIVoc.model.User;
import fr.iutparis8.CSID.backSIVoc.repository.UserEntityRepository;

@Service
public class ConnexionService implements UserDetailsService {
	private final UserEntityRepository userEntityR;

	@Autowired
	public ConnexionService(UserEntityRepository userEntityR) {
		this.userEntityR = userEntityR;
	}

	@Override
	public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username);
		UserEntity userEntity = userEntityR.findOneByUsername(username);
		return userEntity;
	}

	public User createUser(UserDTO userDTO) {

		User user = UserMapper.userDTOtoUser(userDTO);
		UserEntity userEntity = UserMapper.userToUserEntity(user);
		UserEntity retour = userEntityR.save(userEntity); // entity must not be null.
		user = UserMapper.userEntityToUser(retour);
		return user;
	}
}
