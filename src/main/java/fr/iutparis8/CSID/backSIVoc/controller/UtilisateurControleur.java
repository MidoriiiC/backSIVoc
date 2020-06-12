package fr.iutparis8.CSID.backSIVoc.controller;

import java.util.Collection;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iutparis8.CSID.backSIVoc.configuration.SecurityConfiguration;
import fr.iutparis8.CSID.backSIVoc.dto.UtilisateurDTO;
import fr.iutparis8.CSID.backSIVoc.mapper.UtilisateurMapper;
import fr.iutparis8.CSID.backSIVoc.model.BlocPassword;
import fr.iutparis8.CSID.backSIVoc.model.Utilisateur;
import fr.iutparis8.CSID.backSIVoc.service.UtilisateurService;


/**
 * 
 * @author midoriiiC
 * 
 * Le but de la classe UtilisateurControleur est de permettre aux modérateurs et aux admins
 * de créer un compte, de modifier un compte, et de voir la liste des utilisateurs.
 *
 */
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurControleur {

	private UtilisateurService service;

	@Autowired
	public UtilisateurControleur(UtilisateurService us) {
		this.service = us;
	}

	
	
	@RolesAllowed("ROLE_CAN_DO_WHOAMI")
	@GetMapping("/whoami")
	public String whoAmI() {
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
	public String whoAmI3() {
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
	public String whoAmI2() {
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
	public ResponseEntity<?> updateMotDePasse(@PathVariable String utilisateur, @RequestBody BlocPassword bp) {

		bp.setOldPassword(SecurityConfiguration.passwordEncoder().encode(bp.getOldPassword()));
		bp.setNewPassword(SecurityConfiguration.passwordEncoder().encode(bp.getNewPassword()));

		int succes = this.service.updatePassword(bp, utilisateur);
		if (succes == 1)
			return ResponseEntity.ok().build();
		if(succes == 2)
			return ResponseEntity.unprocessableEntity().build();
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/creation")
	public ResponseEntity<?> creerUnCompte(@RequestBody Utilisateur u){
		
		Utilisateur reponse = this.service.creerUtilisateur(u);
		if(reponse.getId()==u.getId()) {
			return ResponseEntity.created(null).build();
		}
		return ResponseEntity.badRequest().build();
	}
	@GetMapping
	public List<UtilisateurDTO> getAllUtilisateurs() {
		List<Utilisateur> listU = this.service.getAllUtilisateurs();
		List<UtilisateurDTO> listDTO = UtilisateurMapper.listUtilisateurToUtilisateurDTO(listU);
		return listDTO;
	}

}