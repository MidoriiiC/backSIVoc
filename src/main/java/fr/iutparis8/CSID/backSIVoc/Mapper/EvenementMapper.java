package fr.iutparis8.CSID.backSIVoc.Mapper;

import java.util.ArrayList;
import java.util.List;

import fr.iutparis8.CSID.backSIVoc.DTO.EvenementDTO;
import fr.iutparis8.CSID.backSIVoc.Entités.EvenementEntite;
import fr.iutparis8.CSID.backSIVoc.Objets.Evenement;

public class EvenementMapper {
	public static Evenement entiteVersObjet(EvenementEntite evenement) {
		return new Evenement(evenement.getId(), evenement.getNom(), evenement.getContenuArticle(),
				evenement.getImage(), evenement.getLienVideo(), evenement.getDate(), evenement.getHeure(),
				evenement.getLieu(), evenement.getOrganisateur());
	}
	
	public static EvenementDTO objetVersDto(Evenement evenement) {
		return new EvenementDTO(evenement.getId(), evenement.getNom(), evenement.getContenuArticle(),
				evenement.getImage(), evenement.getLienVideo(), evenement.getDate(), evenement.getHeure(),
				evenement.getLieu(), evenement.getOrganisateur());
	}
	
	public static EvenementEntite objetVersEntite(Evenement evenement) {
		return new EvenementEntite(evenement.getId(), evenement.getNom(), evenement.getContenuArticle(),
				evenement.getImage(), evenement.getLienVideo(), evenement.getDate(), evenement.getHeure(),
				evenement.getLieu(), evenement.getOrganisateur());
	}
	
	public static Evenement DtoVersObjet(EvenementDTO evenement) {
		return new Evenement(evenement.getId(), evenement.getNom(), evenement.getContenuArticle(),
				evenement.getImage(), evenement.getLienVideo(), evenement.getDate(), evenement.getHeure(),
				evenement.getLieu(), evenement.getOrganisateur());
	}

	public static List<Evenement> listeEntiteVersListeObjet(List<EvenementEntite> evenements) {
		List<Evenement> evenementsObjet = new ArrayList<Evenement>();
		for(EvenementEntite evenement: evenements) {
			evenementsObjet.add(new Evenement(evenement.getId(), evenement.getNom(), evenement.getContenuArticle(),
				evenement.getImage(), evenement.getLienVideo(), evenement.getDate(), evenement.getHeure(),
				evenement.getLieu(), evenement.getOrganisateur()));
		}
		return evenementsObjet;
	}
	
	public static List<EvenementDTO> listeObjetVersListeDTO(List<Evenement> evenements) {
		List<EvenementDTO> evenementsDTO = new ArrayList<EvenementDTO>();
		for(Evenement evenement: evenements) {
			evenementsDTO.add(new EvenementDTO(evenement.getId(), evenement.getNom(), evenement.getContenuArticle(),
				evenement.getImage(), evenement.getLienVideo(), evenement.getDate(), evenement.getHeure(),
				evenement.getLieu(), evenement.getOrganisateur()));
		}
		return evenementsDTO;
	}
}
