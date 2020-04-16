package fr.iutparis8.CSID.backSIVoc.Mapper;

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
}
