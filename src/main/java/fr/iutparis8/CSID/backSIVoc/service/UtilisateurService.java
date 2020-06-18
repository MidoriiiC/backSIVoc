package fr.iutparis8.CSID.backSIVoc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.iutparis8.CSID.backSIVoc.configuration.SecurityConfiguration;
import fr.iutparis8.CSID.backSIVoc.domain.UtilisateurEntity;
import fr.iutparis8.CSID.backSIVoc.enums.RoleEnum;
import fr.iutparis8.CSID.backSIVoc.mapper.UtilisateurMapper;
import fr.iutparis8.CSID.backSIVoc.model.BlocPassword;
import fr.iutparis8.CSID.backSIVoc.model.Utilisateur;
import fr.iutparis8.CSID.backSIVoc.repository.UtilisateurEntityRepository;
import fr.iutparis8.CSID.backSIVoc.repository.UtilisateurRepository;

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
			System.out.println(sqlexc + " " + sqlexc.getCause() + " " + sqlexc.getMessage() + " " + sqlexc.getSQLState());
			return 2;
		}

		return 0;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username);
		UtilisateurEntity user = uer.findOneByUsername(username);
		return user;
	}
	
	public Utilisateur creerUtilisateurRoled(Utilisateur u) {
		if(u.getNom().equals("admin"))
			u.setRole("administrateur");
		if(u.getNom().equals("modo"))
			u.setRole("modérateur");
		if(u.getNom().equals("benev"))
			u.setRole("bénévole");
		
		UtilisateurEntity uent = UtilisateurMapper.utilisateurToUtilisateurEntity(u);
		System.out.println("création utilisateur "+ uent.getUsername());
		
		System.out.println("son rôle :" + uent.getRole());
		UtilisateurEntity retour = ur.save(uent);
		u = UtilisateurMapper.utilisateurEntityToUtilisateur(retour);
		return u;
	}
}
