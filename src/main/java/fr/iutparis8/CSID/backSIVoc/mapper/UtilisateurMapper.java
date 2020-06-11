package fr.iutparis8.CSID.backSIVoc.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import fr.iutparis8.CSID.backSIVoc.domain.UtilisateurEntity;
import fr.iutparis8.CSID.backSIVoc.dto.UtilisateurDTO;
import fr.iutparis8.CSID.backSIVoc.enums.RoleEnum;
import fr.iutparis8.CSID.backSIVoc.model.Utilisateur;

public class UtilisateurMapper {
	
	public static Utilisateur utilisateurDTOtoUtilisateur(UtilisateurDTO dto) {
		Utilisateur u = new Utilisateur();
		u.setId(dto.getId());
		u.setNom(dto.getNom());
		u.setPrenom(dto.getPrenom());
		u.setEmail(dto.getEmail());
		u.setRole(dto.getRole());
		u.setMdp(dto.getMdp());
		return u;
	}

	public static UtilisateurEntity utilisateurToUtilisateurEntity(Utilisateur u) { // 2
		Collection<RoleEnum> auth = new ArrayList<RoleEnum>();
		auth.add(RoleEnum.ROLE_UTILISATEUR);
		UtilisateurEntity uent = new UtilisateurEntity();
		uent.setId(u.getId());
		uent.setUsername(u.getNom());
		uent.setPassword(u.getMdp());
		uent.setEmail(u.getEmail());
		uent.setFirstname(u.getPrenom());
		uent.setRole(u.getRole());

		uent.setAccountNonLocked(true);
		uent.setCredentialsNonExpired(true);
		uent.setEnabled(true);
		uent.setAccountNonExpired(true);

		System.out.println(uent.toString());
		return uent;
	}

	public static Utilisateur utilisateurEntityToUtilisateur(UtilisateurEntity uent) { // 3
		if(uent == null) return null;
		Utilisateur u = new Utilisateur();
		u.setId(uent.getId());
		u.setNom(uent.getUsername());
		u.setMdp(uent.getPassword());
		u.setEmail(uent.getEmail());
		u.setPrenom(uent.getFirstname());
		u.setRole(uent.getRole());
		return u;
	}

	public static UtilisateurDTO utilisateurToUtilisateurDTO(Utilisateur e) { // 4
		if(e == null) return null;
		UtilisateurDTO dto = new UtilisateurDTO(e.getId());
		dto.setNom(e.getNom());
		dto.setPrenom(e.getPrenom());
		dto.setMdp(e.getMdp());
		dto.setEmail(e.getEmail());
		dto.setRole(e.getRole());
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
