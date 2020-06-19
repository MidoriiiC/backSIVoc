package fr.iutparis8.CSID.backSIVoc.model;

public class Volunteering {
	
	private int idVolunteering;
	
	
	private String label;
	
	private User volunteer;
	
	private String description;
	
	private String scheldule;
	
	private int eventId;
	
	public Volunteering() {
		
	}

	public Volunteering(int idVolunteering, String label, User volunteer,
			String description, String scheldule, int eventId) {
		super();
		this.idVolunteering = idVolunteering;
		this.label = label;
		this.volunteer = volunteer;
		this.description = description;
		this.scheldule = scheldule;
		this.eventId = eventId;
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

	public User getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(User volunteer) {
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
	

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	

	
}
