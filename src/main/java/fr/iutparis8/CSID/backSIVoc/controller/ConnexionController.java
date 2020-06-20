package fr.iutparis8.CSID.backSIVoc.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iutparis8.CSID.backSIVoc.domain.UserEntity;
import fr.iutparis8.CSID.backSIVoc.dto.UserDTO;
import fr.iutparis8.CSID.backSIVoc.mapper.UserMapper;
import fr.iutparis8.CSID.backSIVoc.model.Authentification;
import fr.iutparis8.CSID.backSIVoc.model.User;
import fr.iutparis8.CSID.backSIVoc.service.ConnexionService;

@RestController
@RequestMapping("/connexion")
public class ConnexionController {

	private ConnexionService service;

	@Autowired
	public ConnexionController(ConnexionService cs) {
		this.service = cs;
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<?> getConnexion(@RequestBody Authentification auth) {
		//auth.setMdp(SecurityConfiguration.passwordEncoder().encode(auth.getMdp()));
		if (auth != null) {
			UserEntity ue = this.service.loadUserByUsername(auth.getName());
			if (ue != null) {
				User u = UserMapper.userEntityToUser(ue);
				UserDTO dto = UserMapper.userToUserDTO(u);
				if (auth.getName().equals(dto.getName()) && auth.getPassword().equals(dto.getPassword()))
					return ResponseEntity.ok().body(dto);
				}
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/creation")
	public ResponseEntity<?> creationAccount(@RequestBody UserDTO auth) throws URISyntaxException {
		auth.setAuthority("utilisateur");
		User reponse = this.service.createUser(auth);
		if (reponse.getName() == auth.getName()) {
			return ResponseEntity.created(null).build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/infos")
	public UserDTO info() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUser = null;
		if (authentication != null) {
			currentUser = authentication.getName();
		}
		UserEntity ue = this.service.loadUserByUsername(currentUser);
		User u = UserMapper.userEntityToUser(ue);
		UserDTO dto = UserMapper.userToUserDTO(u);
		return dto;
	}

}
