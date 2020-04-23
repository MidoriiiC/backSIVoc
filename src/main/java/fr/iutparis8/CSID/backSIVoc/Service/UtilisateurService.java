package fr.iutparis8.CSID.backSIVoc.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.Configuration.SecurityConfiguration;
import fr.iutparis8.CSID.backSIVoc.Entités.UtilisateurEntity;
import fr.iutparis8.CSID.backSIVoc.Mapper.UtilisateurMapper;
import fr.iutparis8.CSID.backSIVoc.Objets.BlocPassword;
import fr.iutparis8.CSID.backSIVoc.Objets.Utilisateur;
import fr.iutparis8.CSID.backSIVoc.Repository.UtilisateurEntityRepository;
import fr.iutparis8.CSID.backSIVoc.Repository.UtilisateurRepository;

@Service
public class UtilisateurService implements UserDetailsService {
	
	private UtilisateurRepository ur;
	private UtilisateurEntityRepository uer;

	@Autowired
	public UtilisateurService(UtilisateurRepository urep, UtilisateurEntityRepository uerep) {
		this.ur = urep;
		this.uer=uerep;
	}
	
	public Utilisateur creerUtilisateur(Utilisateur u) {
		UtilisateurEntity eent = UtilisateurMapper.utilisateurToUtilisateurEntity(u);
		UtilisateurEntity retour = ur.save(eent);
		u = UtilisateurMapper.utilisateurEntityToUtilisateur(retour);
		return u;
	}
	
//	public Utilisateur getUtilisateurParNom(String nom) {
//		UtilisateurEntity uent = this.uer.findByUsername(nom);
//		Utilisateur e = UtilisateurMapper.utilisateurEntityToUtilisateur(uent);
//		return e;
//	}
	
	public List<Utilisateur> getAllUtilisateurs() {
		List<UtilisateurEntity> listUent = this.ur.findAll();
		List<Utilisateur> listE = UtilisateurMapper.listeUtilisateurEntityToUtilisateur(listUent);
		return listE;
	}
	

	public int updatePassword(BlocPassword bp, String utilisateur){  //TODO ne marche pas, erreur SQL engendrée

		String oldP = bp.getOldPassword();
		String newP = bp.getNewPassword();
		Connection conn;
		try {
			conn = SecurityConfiguration.getDataSource().getConnection(utilisateur, oldP);
			System.out.println(conn.getMetaData().toString());
			if (conn.isValid(0)) {
				System.out.println(conn.getMetaData().toString());
				SecurityConfiguration.jdbcUserDetailsManager().changePassword(oldP, newP);
				return 1;// goodConnection
			}
		} catch (SQLException sqlexc) {
			System.out.println(sqlexc +" "+ sqlexc.getCause() +" "+ sqlexc.getMessage() +" "+ sqlexc.getSQLState());
			return 2;
		}

		return 0;
	}
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        UtilisateurEntity user = uer.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }
}
