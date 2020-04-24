package fr.iutparis8.CSID.backSIVoc.Controleur;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.iutparis8.CSID.backSIVoc.Configuration.SecurityConfiguration;
import fr.iutparis8.CSID.backSIVoc.Objets.CreationCompte;
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
	public String getConnexion() {
		try {
			Connection c = SecurityConfiguration.getDataSource().getConnection();
			System.out.println(c.isValid(0));
			return "is valid";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "a tester";
	}

	@PostMapping
	public ResponseEntity<?> creationCompte(@RequestBody CreationCompte auth) throws URISyntaxException { // ne marche
																											// pas bien
		Utilisateur u = new Utilisateur();
		u.setId(auth.getId());
		u.setNom(auth.getNom());
		u.setMdp(SecurityConfiguration.passwordEncoder().encode(auth.getMdp()));
		u.setRole(RoleEnum.UTILISATEUR);
		System.out.println("dans ConnectionC, u= " + u.toString());
		Utilisateur reponse = this.service.creerUtilisateur(u);
		if (reponse.getNom() == u.getNom()) {
			return ResponseEntity.created(null).build();
		}
		return ResponseEntity.badRequest().build();
	}

}
