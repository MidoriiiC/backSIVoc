package fr.iutparis8.CSID.backSIVoc.Mapper;

import java.util.ArrayList;
import java.util.List;

import fr.iutparis8.CSID.backSIVoc.DTO.EvenementDTO;
import fr.iutparis8.CSID.backSIVoc.Objets.Evenement;
import fr.iutparis8.CSID.backSIVoc.domain.EvenementEntite;

public class EvenementMapper {
	public static Evenement entiteVersObjet(EvenementEntite evenement) {
		System.out.println(evenement.getVolontaires());
		return new Evenement(evenement.getId(), evenement.getNom(), evenement.getContenuArticle(),
				evenement.getImage(), evenement.getLienVideo(), evenement.getDate(), evenement.getHeure(),
				evenement.getLieu(), evenement.getOrganisateur(), VolunteeringMapper.listEntityToListObject(evenement.getVolontaires()));
	}
	
	public static EvenementDTO objetVersDto(Evenement evenement) {
		return new EvenementDTO(evenement.getId(), evenement.getNom(), evenement.getContenuArticle(),
				evenement.getImage(), evenement.getLienVideo(), evenement.getDate(), evenement.getHeure(),
				evenement.getLieu(), evenement.getOrganisateur(), VolunteeringMapper.listObjectToListDTO(evenement.getVolontaires()));
	}
	
	public static EvenementEntite objetVersEntite(Evenement evenement) {
		return new EvenementEntite(evenement.getId(), evenement.getNom(), evenement.getContenuArticle(),
				evenement.getImage(), evenement.getLienVideo(), evenement.getDate(), evenement.getHeure(),
				evenement.getLieu(), evenement.getOrganisateur(), VolunteeringMapper.listObjectToListEntity(evenement.getVolontaires()));
	}
	
	public static Evenement DtoVersObjet(EvenementDTO evenement) {
		return new Evenement(evenement.getId(), evenement.getNom(), evenement.getContenuArticle(),
				evenement.getImage(), evenement.getLienVideo(), evenement.getDate(), evenement.getHeure(),
				evenement.getLieu(), evenement.getOrganisateur(), VolunteeringMapper.listDTOToListObject(evenement.getVolontaires()));
	}

	public static List<Evenement> listeEntiteVersListeObjet(List<EvenementEntite> evenements) {
		List<Evenement> evenementsObjet = new ArrayList<Evenement>();
		for(EvenementEntite evenement: evenements) {
			evenementsObjet.add(new Evenement(evenement.getId(), evenement.getNom(), evenement.getContenuArticle(),
				evenement.getImage(), evenement.getLienVideo(), evenement.getDate(), evenement.getHeure(),
				evenement.getLieu(), evenement.getOrganisateur(), VolunteeringMapper.listEntityToListObject(evenement.getVolontaires())));
		}
		return evenementsObjet;
	}
	
	public static List<EvenementDTO> listeObjetVersListeDTO(List<Evenement> evenements) {
		List<EvenementDTO> evenementsDTO = new ArrayList<EvenementDTO>();
		for(Evenement evenement: evenements) {
			evenementsDTO.add(new EvenementDTO(evenement.getId(), evenement.getNom(), evenement.getContenuArticle(),
				evenement.getImage(), evenement.getLienVideo(), evenement.getDate(), evenement.getHeure(),
				evenement.getLieu(), evenement.getOrganisateur(), VolunteeringMapper.listObjectToListDTO(evenement.getVolontaires())));
		}
		return evenementsDTO;
	}
}
