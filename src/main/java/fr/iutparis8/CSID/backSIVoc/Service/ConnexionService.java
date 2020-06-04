package fr.iutparis8.CSID.backSIVoc.Service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.DTO.UtilisateurDTO;
import fr.iutparis8.CSID.backSIVoc.Mapper.UtilisateurMapper;
import fr.iutparis8.CSID.backSIVoc.Objets.Utilisateur;
import fr.iutparis8.CSID.backSIVoc.Repository.UtilisateurEntityRepository;
import fr.iutparis8.CSID.backSIVoc.domain.UtilisateurEntity;

@Service
public class ConnexionService implements UserDetailsService {
	private final UtilisateurEntityRepository uer;

	@Autowired
	public ConnexionService(UtilisateurEntityRepository userRepository) {
		this.uer = userRepository;
	}

	@Override
	public UtilisateurEntity loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username);
		UtilisateurEntity user = uer.findOneByUsername(username);
		return user;
	}

	public Utilisateur creerUtilisateur(UtilisateurDTO dto) {

		Utilisateur u = UtilisateurMapper.utilisateurDTOtoUtilisateur(dto);
		UtilisateurEntity eent = UtilisateurMapper.utilisateurToUtilisateurEntity(u);
		UtilisateurEntity retour = uer.save(eent); // entity must not be null.
		u = UtilisateurMapper.utilisateurEntityToUtilisateur(retour);
		return u;
	}
}
