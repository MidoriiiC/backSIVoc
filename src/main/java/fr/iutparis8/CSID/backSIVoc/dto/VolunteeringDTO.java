package fr.iutparis8.CSID.backSIVoc.dto;

public class VolunteeringDTO {

	private int idVolunteering;

	private String label;

	private UserDTO volunteer;

	private String description;

	private String scheldule;

	private int eventId;

	public VolunteeringDTO() {

	}

	public VolunteeringDTO(int idVolunteering, String label, UserDTO volunteer, String description, String scheldule,
			int eventId) {
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

	public UserDTO getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(UserDTO volunteer) {
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
