package fr.iutparis8.CSID.backSIVoc.model;

public class Volunteering {
	
	private int idVolunteering;
	
	
	private String label;
	
	private Utilisateur volunteer;
	
	private String description;
	
	private String scheldule;
	
	public Volunteering() {
		
	}

	public Volunteering(int idVolunteering, String label, Utilisateur volunteer,
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

	public Utilisateur getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(Utilisateur volunteer) {
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
