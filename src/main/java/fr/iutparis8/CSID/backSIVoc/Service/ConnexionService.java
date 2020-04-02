package fr.iutparis8.CSID.backSIVoc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.Entités.UtilisateurEntity;
import fr.iutparis8.CSID.backSIVoc.Mapper.UtilisateurMapper;
import fr.iutparis8.CSID.backSIVoc.Objets.Utilisateur;
import fr.iutparis8.CSID.backSIVoc.Repository.UtilisateurRepository;

@Service
public class ConnexionService {
	
	private UtilisateurRepository ur;

	@Autowired
	public ConnexionService(UtilisateurRepository urep) {
		this.ur = urep;
	}

	public Utilisateur creerUtilisateur(Utilisateur u) {

		UtilisateurEntity eent = UtilisateurMapper.utilisateurToUtilisateurEntity(u);
		System.out.println(eent.getId()+ " " +eent.getUsername()+ " "+ eent.getPassword());
		UtilisateurEntity retour = ur.save(eent);  //entity must not be null.
		System.out.println(" pas de pb dans le save(objet)");
		u = UtilisateurMapper.utilisateurEntityToUtilisateur(retour);
		return u;
	}

}
