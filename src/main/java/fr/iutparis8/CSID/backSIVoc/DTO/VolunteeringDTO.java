package fr.iutparis8.CSID.backSIVoc.DTO;

public class VolunteeringDTO {
	
	private int idVolunteering;
	
	
	private String label;
	
	private UtilisateurDTO volunteer;
	
	private String description;
	
	private String scheldule;
	
	public VolunteeringDTO() {
		
	}

	public VolunteeringDTO(int idVolunteering, String label, UtilisateurDTO volunteer,
			String description, String scheldule) {
		super();
		this.idVolunteering = idVolunteering;
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
