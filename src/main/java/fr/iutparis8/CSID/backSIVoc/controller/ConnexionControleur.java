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

import fr.iutparis8.CSID.backSIVoc.configuration.SecurityConfiguration;
import fr.iutparis8.CSID.backSIVoc.domain.UtilisateurEntity;
import fr.iutparis8.CSID.backSIVoc.dto.UtilisateurDTO;
import fr.iutparis8.CSID.backSIVoc.enums.RoleEnum;
import fr.iutparis8.CSID.backSIVoc.mapper.UtilisateurMapper;
import fr.iutparis8.CSID.backSIVoc.model.Authentification;
import fr.iutparis8.CSID.backSIVoc.model.Utilisateur;
import fr.iutparis8.CSID.backSIVoc.service.ConnexionService;

@RestController
@RequestMapping("/connexion")
public class ConnexionControleur {

	private ConnexionService service;

	@Autowired
	public ConnexionControleur(ConnexionService cs) {
		this.service = cs;
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<?> getConnexion(@RequestBody Authentification auth) {
		//auth.setMdp(SecurityConfiguration.passwordEncoder().encode(auth.getMdp()));
		if (auth != null) {
			System.out.println("pour l'auth: " + auth.getNom() + " et mdp:" + auth.getMdp());
			UtilisateurEntity ue = this.service.loadUserByUsername(auth.getNom());
			if (ue != null) {
				Utilisateur u = UtilisateurMapper.utilisateurEntityToUtilisateur(ue);
				UtilisateurDTO dto = UtilisateurMapper.utilisateurToUtilisateurDTO(u);
				System.out.println("pour l'auth: " + auth.getNom() + " et mdp:" + auth.getMdp());
				System.out.println("pour le DTO: " + dto.getNom() + " et mdp: " + dto.getMdp());

				if (auth.getNom().equals(dto.getNom()) && auth.getMdp().equals(dto.getMdp()))
					return ResponseEntity.ok().body(dto);
				//System.out.println("mauvais mdp\n");
			}
			else {
				//System.out.println("mauvais login\n");
			}
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
	}

	// fonction de debug
	@PostMapping("/creationlambda")
	public ResponseEntity<?> creationComptesLambda() {
		boolean allCreationsIsOK;
		UtilisateurDTO u = new UtilisateurDTO();
		u.setId(1);
		u.setNom("utilisateur");
		u.setMdp(SecurityConfiguration.passwordEncoder().encode("mdp"));
		u.setRole(RoleEnum.ROLE_UTILISATEUR);
		Utilisateur reponse = this.service.creerUtilisateur(u);
		if (reponse.getNom() == u.getNom()) {
			allCreationsIsOK = true;
		} else
			allCreationsIsOK = false;

		u.setId(2);
		u.setNom("moderateur");
		u.setMdp(SecurityConfiguration.passwordEncoder().encode("mdp"));
		u.setRole(RoleEnum.ROLE_MODERATEUR);
		reponse = this.service.creerUtilisateur(u);
		if (reponse.getNom() == u.getNom()) {
			allCreationsIsOK = true;
		} else
			allCreationsIsOK = false;

		u.setId(3);
		u.setNom("admin");
		u.setMdp(SecurityConfiguration.passwordEncoder().encode("mdp"));
		u.setRole(RoleEnum.ROLE_ADMINISTRATEUR);
		reponse = this.service.creerUtilisateur(u);
		if (reponse.getNom() == u.getNom()) {
			allCreationsIsOK = true;
		} else
			allCreationsIsOK = false;

		if (allCreationsIsOK)
			return ResponseEntity.created(null).build();

		return ResponseEntity.badRequest().build();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/creation")
	public ResponseEntity<?> creationCompte(@RequestBody UtilisateurDTO auth) throws URISyntaxException {
		//auth.setMdp(SecurityConfiguration.passwordEncoder().encode(auth.getMdp()));
		auth.setRole(RoleEnum.ROLE_UTILISATEUR);
		Utilisateur reponse = this.service.creerUtilisateur(auth);
		if (reponse.getNom() == auth.getNom()) {
			return ResponseEntity.created(null).build();
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/infos")
	public UtilisateurDTO info() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUser = null;
		if (authentication != null) {
			currentUser = authentication.getName();
		}
		UtilisateurEntity ue = this.service.loadUserByUsername(currentUser);
		Utilisateur u = UtilisateurMapper.utilisateurEntityToUtilisateur(ue);
		UtilisateurDTO dto = UtilisateurMapper.utilisateurToUtilisateurDTO(u);
		return dto;
	}

}
