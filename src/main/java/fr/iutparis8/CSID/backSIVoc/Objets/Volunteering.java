package fr.iutparis8.CSID.backSIVoc.Objets;

public class Volunteering {
	
	private int idVolunteering;
	
	private Evenement event;
	
	private String label;
	
	private Utilisateur volunteer;
	
	private String description;
	
	private String scheldule;
	
	public Volunteering() {
		
	}

	public Volunteering(int idVolunteering, Evenement event, String label, Utilisateur volunteer,
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

	public Evenement getEvent() {
		return event;
	}

	public void setEvent(Evenement event) {
		this.event = event;
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
