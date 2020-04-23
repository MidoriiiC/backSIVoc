package fr.iutparis8.CSID.backSIVoc.Mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;

import fr.iutparis8.CSID.backSIVoc.DTO.UtilisateurDTO;
import fr.iutparis8.CSID.backSIVoc.Entités.UtilisateurEntity;
import fr.iutparis8.CSID.backSIVoc.Objets.Utilisateur;
import fr.iutparis8.CSID.backSIVoc.enums.RoleEnum;

public class UtilisateurMapper {
	
	public static UtilisateurEntity utilisateurToUtilisateurEntity(Utilisateur u) {  //2
		Collection<RoleEnum> auth = new ArrayList<RoleEnum>();
		auth.add(RoleEnum.UTILISATEUR);
    	UtilisateurEntity uent = new UtilisateurEntity();
    	uent.setId(u.getId());
    	uent.setUsername(u.getNom());
    	uent.setPassword(u.getMdp());
    	uent.setRole(u.getRole());
    	
    	uent.setAccountNonLocked(true);
    	uent.setCredentialsNonExpired(true);
    	uent.setEnabled(true);
    	uent.setAccountNonExpired(true);
    	
		System.out.println(uent.toString());
		return uent;
	}
	
	public static Utilisateur utilisateurEntityToUtilisateur(UtilisateurEntity uent) {  //3
		Utilisateur u = new Utilisateur();
		u.setId(uent.getId());
		u.setNom(uent.getUsername());
		u.setMdp(uent.getPassword());
		return u;
	}
	public static UtilisateurDTO utilisateurToUtilisateurDTO(Utilisateur e) {  //4
		UtilisateurDTO dto = new UtilisateurDTO(e.getId());
		dto.setNom(e.getNom());
		dto.setMdp(e.getMdp());
		return dto;
	}

	public static List<Utilisateur> listeUtilisateurEntityToUtilisateur(List<UtilisateurEntity> listUent) {
		List<Utilisateur> listU = new ArrayList<Utilisateur>();
		for (Iterator<UtilisateurEntity> it = listUent.iterator(); it.hasNext();) {
			Utilisateur e = UtilisateurMapper.utilisateurEntityToUtilisateur(it.next());
			listU.add(e);
		}
		return listU;
	}

	public static List<UtilisateurDTO> listUtilisateurToUtilisateurDTO(List<Utilisateur> listU) {
		List<UtilisateurDTO> listDTO = new ArrayList<UtilisateurDTO>();
		for (Iterator<Utilisateur> it = listU.iterator(); it.hasNext();) {
			UtilisateurDTO u = UtilisateurMapper.utilisateurToUtilisateurDTO(it.next());
			listDTO.add(u);
		}
		return listDTO;
	}
	

}
