package fr.iutparis8.CSID.backSIVoc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//create table volunteering (idEvent integer, idVolunteering serial, label varchar, volunteer varchar, description varchar (3000), scheldule varchar, primary key (idEvent, idVolunteering));

@Entity
@Table(name="volunteering")
public class VolunteeringEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idVolunteering")
	private int idVolunteering;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private EventEntity event;
	
	@Column(name="label")
	private String label;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="volunteer_id")
	private UtilisateurEntity volunteer;
	
	@Column(name="description")
	private String description;
	
	@Column(name="scheldule")
	private String scheldule;
	
	public VolunteeringEntity() {
		
	}

	public VolunteeringEntity(int idVolunteering, String label, UtilisateurEntity volunteer,
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

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public UtilisateurEntity getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(UtilisateurEntity volunteer) {
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
