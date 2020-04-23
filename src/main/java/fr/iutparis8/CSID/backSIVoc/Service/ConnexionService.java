package fr.iutparis8.CSID.backSIVoc.Service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.Entités.UtilisateurEntity;
import fr.iutparis8.CSID.backSIVoc.Mapper.UtilisateurMapper;
import fr.iutparis8.CSID.backSIVoc.Objets.Utilisateur;
import fr.iutparis8.CSID.backSIVoc.Repository.UtilisateurEntityRepository;

@Service
public class ConnexionService implements UserDetailsService {
	    private final UtilisateurEntityRepository uer;
	    @Autowired
	    public ConnexionService(UtilisateurEntityRepository userRepository) {
	        this.uer = userRepository;
	    }
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	        Objects.requireNonNull(username);
//	        UtilisateurEntity user = uer.findUserWithName(username)
//	                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//	        return user;
	    	return null;
	    }

	public Utilisateur creerUtilisateur(Utilisateur u) {

		UtilisateurEntity eent = UtilisateurMapper.utilisateurToUtilisateurEntity(u);
		System.out.println("dans connexionS, Ue= " + eent.toString());
		UtilisateurEntity retour = uer.save(eent);  //entity must not be null.
		System.out.println(" pas de pb dans le save(objet)");
		u = UtilisateurMapper.utilisateurEntityToUtilisateur(retour);
		return u;
	}

}
