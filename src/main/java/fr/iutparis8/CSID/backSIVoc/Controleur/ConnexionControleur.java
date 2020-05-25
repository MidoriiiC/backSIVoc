package fr.iutparis8.CSID.backSIVoc.Controleur;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iutparis8.CSID.backSIVoc.Configuration.SecurityConfiguration;
import fr.iutparis8.CSID.backSIVoc.DTO.UtilisateurDTO;
import fr.iutparis8.CSID.backSIVoc.Entités.UtilisateurEntity;
import fr.iutparis8.CSID.backSIVoc.Mapper.UtilisateurMapper;
import fr.iutparis8.CSID.backSIVoc.Objets.Utilisateur;
import fr.iutparis8.CSID.backSIVoc.Service.ConnexionService;
import fr.iutparis8.CSID.backSIVoc.enums.RoleEnum;

@RestController
@RequestMapping("/connexion")
public class ConnexionControleur {

	private ConnexionService service;

	@Autowired
	public ConnexionControleur(ConnexionService cs) {
		this.service = cs;
	}

	@GetMapping
	public String getConnexionBase() {
		try {
			Connection c = SecurityConfiguration.getDataSource().getConnection();
			System.out.println(c.isValid(0));
			return "is valid";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "a tester";
	}

	// fonction debug 
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
	public ResponseEntity<?> creationCompte(@RequestBody UtilisateurDTO auth) throws URISyntaxException { // ne marche
			// pas bien
		System.out.println(auth.getNom() + auth.getMdp());
		auth.setMdp(SecurityConfiguration.passwordEncoder().encode(auth.getMdp()));
		System.out.println(auth.getMdp());
		auth.setRole(RoleEnum.ROLE_UTILISATEUR);
		Utilisateur reponse = this.service.creerUtilisateur(auth);
		if (reponse.getNom() == auth.getNom()) {
			return ResponseEntity.created(null).build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/infos")
	public UtilisateurDTO info(){
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentUser = null;
			if (authentication != null) {
				currentUser = authentication.getName();
			}
			UtilisateurEntity ue = this.service.loadUserByUsername(currentUser);
			Utilisateur  u= UtilisateurMapper.utilisateurEntityToUtilisateur(ue);
			UtilisateurDTO dto = UtilisateurMapper.utilisateurToUtilisateurDTO(u);
			return dto;
	}
	@PostMapping
	public Authentication connexion() {
		return null;
	}

}
