package fr.iutparis8.CSID.backSIVoc.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.iutparis8.CSID.backSIVoc.domain.UserEntity;
import fr.iutparis8.CSID.backSIVoc.dto.UserDTO;
import fr.iutparis8.CSID.backSIVoc.enums.AuthorityEnum;
import fr.iutparis8.CSID.backSIVoc.model.User;

public class UserMapper {
	
	public static User userDTOtoUser(UserDTO userDTO) {
		if(userDTO == null) return null;
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setFirstname(userDTO.getFirstname());
		user.setEmail(userDTO.getEmail());
		user.setAuthority(userDTO.getAuthority());
		user.setPassword(userDTO.getPassword());
		return user;
	}

	public static UserEntity userToUserEntity(User user) {
		if(user == null) return null;
		UserEntity userEntity = new UserEntity();
		userEntity.setId(user.getId());
		userEntity.setUsername(user.getName());
		userEntity.setPassword(user.getPassword());
		userEntity.setEmail(user.getEmail());
		userEntity.setFirstname(user.getFirstname());
		userEntity.setAuthority(stringInterceptorToAuthorityEnum(user.getAuthority()));

		userEntity.setAccountNonLocked(true);
		userEntity.setCredentialsNonExpired(true);
		userEntity.setEnabled(true);
		userEntity.setAccountNonExpired(true);
		return userEntity;
	}

	public static User userEntityToUser(UserEntity userEntity) {
		if(userEntity == null) return null;
		User user = new User();
		user.setId(userEntity.getId());
		user.setName(userEntity.getUsername());
		user.setPassword(userEntity.getPassword());
		user.setEmail(userEntity.getEmail());
		user.setFirstname(userEntity.getFirstname());
		user.setAuthority(authorityEnumInterceptorToString(userEntity.getAutority()));
		return user;
	}

	public static UserDTO userToUserDTO(User user) {
		if(user == null) return null;
		UserDTO userDTO = new UserDTO(user.getId());
		userDTO.setName(user.getName());
		userDTO.setFirstname(user.getFirstname());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		userDTO.setAuthority(user.getAuthority());
		return userDTO;
	}

	public static List<User> listUserEntityToListUser(List<UserEntity> listUserEntity) {
		List<User> listUser = new ArrayList<User>();
		for (Iterator<UserEntity> iterator = listUserEntity.iterator(); iterator.hasNext();) {
			User user = UserMapper.userEntityToUser(iterator.next());
			listUser.add(user);
		}
		return listUser;
	}

	public static List<UserDTO> listUserToUserDTO(List<User> listUser) {
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		for (Iterator<User> iterator = listUser.iterator(); iterator.hasNext();) {
			UserDTO userDTO = UserMapper.userToUserDTO(iterator.next());
			
			listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}

	private static String authorityEnumInterceptorToString(AuthorityEnum authority) {
		switch(authority) {
			case AUTHORITY_ADMINISTRATOR :{
				return "administrateur";
			}
			case AUTHORITY_MODERATOR :{
				return "modérateur";
			}
			case AUTHORITY_UTILISATOR :{
				return "utilisateur";
			}
			case AUTHORITY_VOLUNTEER :{
				return "bénévole";
			}
			case AUTHORITY_PRIEST :{
				return "prêtre";
			}
		default:
			return null;
			
		}
	}
	private static AuthorityEnum stringInterceptorToAuthorityEnum(String authority) {
		switch(authority) {
			case  "administrateur":{
				return AuthorityEnum.AUTHORITY_ADMINISTRATOR;
			}
			case "modérateur" :{
				return AuthorityEnum.AUTHORITY_MODERATOR;
			}
			case "utilisateur" :{
				return AuthorityEnum.AUTHORITY_UTILISATOR;
			}
			case "bénévole" :{
				return AuthorityEnum.AUTHORITY_VOLUNTEER;
			}
			case "prêtre" :{
				return AuthorityEnum.AUTHORITY_PRIEST;
			}
		default:
			return null;
			
		}
	}

}
