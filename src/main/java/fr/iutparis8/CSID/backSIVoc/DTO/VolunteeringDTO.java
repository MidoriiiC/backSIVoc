package fr.iutparis8.CSID.backSIVoc.DTO;

import fr.iutparis8.CSID.backSIVoc.Objets.Evenement;
import fr.iutparis8.CSID.backSIVoc.Objets.Utilisateur;

public class VolunteeringDTO {
	
	private int idVolunteering;
	
	private EvenementDTO event;
	
	private String label;
	
	private UtilisateurDTO volunteer;
	
	private String description;
	
	private String scheldule;
	
	public VolunteeringDTO() {
		
	}

	public VolunteeringDTO(int idVolunteering, EvenementDTO event, String label, UtilisateurDTO volunteer,
			String description, String scheldule) {
		super();
		this.idVolunteering = idVolunteering;
		this.event = event;
		this.label = label;
		this.volunteer = volunteer;
		this.description = description;
		this.scheldule = scheldule;
	}

	public int getIdVolunteering() {
		return idVolunteering;
	}

	public void setIdVolunteering(int idVolunteering) {
		this.idVolunteering = idVolunteering;
	}

	public EvenementDTO getEvent() {
		return event;
	}

	public void setEvent(EvenementDTO event) {
		this.event = event;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public UtilisateurDTO getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(UtilisateurDTO volunteer) {
		this.volunteer = volunteer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScheldule() {
		return scheldule;
	}

	public void setScheldule(String scheldule) {
		this.scheldule = scheldule;
	}

	
}
