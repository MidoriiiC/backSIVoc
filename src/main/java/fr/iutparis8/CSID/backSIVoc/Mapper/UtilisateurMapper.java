package fr.iutparis8.CSID.backSIVoc.Mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.iutparis8.CSID.backSIVoc.DTO.UtilisateurDTO;
import fr.iutparis8.CSID.backSIVoc.Entités.UtilisateurEntity;
import fr.iutparis8.CSID.backSIVoc.Objets.Utilisateur;

public class UtilisateurMapper {
	
	
	public static UtilisateurEntity utilisateurToUtilisateurEntity(Utilisateur u) {  //2
		UtilisateurEntity uent = new UtilisateurEntity();
		uent.setId(u.getId());
		uent.setNom(u.getNom());
		uent.setPassword(u.getMdp());
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
