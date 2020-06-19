package fr.iutparis8.CSID.backSIVoc.controller;

import java.util.Collection;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iutparis8.CSID.backSIVoc.dto.UserDTO;
import fr.iutparis8.CSID.backSIVoc.mapper.UserMapper;
import fr.iutparis8.CSID.backSIVoc.model.BlocPassword;
import fr.iutparis8.CSID.backSIVoc.model.User;
import fr.iutparis8.CSID.backSIVoc.service.UserService;


/**
 * 
 * @author midoriiiC
 * 
 * Le but de la classe UtilisateurControleur est de permettre aux modérateurs et aux admins
 * de créer un compte, de modifier un compte, et de voir la liste des utilisateurs.
 *
 */
@RestController
@RequestMapping("/users")
public class UserControleur {

	private UserService service;

	@Autowired
	public UserControleur(UserService userS) {
		this.service = userS;
	}

	
	
	@RolesAllowed("ROLE_CAN_DO_WHOAMI")
	@GetMapping("/whoami")
	public String whoAmI() {  //fonction qui va disparaître
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUser = null;
		String currentCred = null;
		Collection<? extends GrantedAuthority> roles = null;
		if (authentication != null) {
			currentUser = authentication.getName();
			currentCred = (String) authentication.getCredentials();
			roles = authentication.getAuthorities();
		}
		System.out.println("http GET /utilisateurs/whoami currentUser:" + currentUser + " cred:" + currentCred
				+ " roles:" + roles);
		return currentUser;
	}
	
	@GetMapping("/whoami3")
	public String whoAmI3() {  //fonction qui va disparaître
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUser = null;
		String currentCred = null;
		Collection<? extends GrantedAuthority> roles = null;
		if (authentication != null) {
			currentUser = authentication.getName();
			currentCred = (String) authentication.getCredentials();
			roles = authentication.getAuthorities();
		}
		System.out.println("http GET /utilisateurs/whoami currentUser:" + currentUser + " cred:" + currentCred
				+ " roles:" + roles);
		return currentUser;
	}
	
	@RolesAllowed("ROLE_CAN_DO_WHOAMI__")
	@GetMapping("/whoami2")
	public String whoAmI2() {   //fonction qui va disparaître
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUser = null;
		String currentCred = null;
		Collection<? extends GrantedAuthority> roles = null;
		if (authentication != null) {
			currentUser = authentication.getName();
			currentCred = (String) authentication.getCredentials();
			roles = authentication.getAuthorities();
		}
		System.out.println("http GET /utilisateurs/whoami currentUser:" + currentUser + " cred:" + currentCred
				+ " roles:" + roles);
		return currentUser;
	}
	
	@PutMapping("/{utilisateur}")
	public ResponseEntity<?> updatePassword(@PathVariable String utilisateur, @RequestBody BlocPassword blockPassword) {
		int success = this.service.updatePassword(blockPassword, utilisateur);
		if (success == 1)
			return ResponseEntity.ok().build();
		if(success == 2)
			return ResponseEntity.unprocessableEntity().build();
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createAccount(@RequestBody User user){
		
		User reponse = this.service.createUser(user);
		if(reponse.getId()==user.getId()) {
			return ResponseEntity.created(null).build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public List<UserDTO> getAllUsers() {
		List<User> listU = this.service.getAllUsers();
		List<UserDTO> listDTO = UserMapper.listUserToUserDTO(listU);
		return listDTO;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/createUserWithAuthority")
	public ResponseEntity<?> createAccountwithAuthority(@RequestBody UserDTO userDTo){
		User user = UserMapper.userDTOtoUser(userDTo);
		User reponse = this.service.createUserWithAuthority(user);
		if(reponse.getName()==userDTo.getName())
			return ResponseEntity.created(null).build();
		return ResponseEntity.badRequest().build();
	}

}
