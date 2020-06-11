package fr.iutparis8.CSID.backSIVoc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "evenement")
public class EventEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "contentArticle")
	private String contentArticle;

	@Column(name = "image")
	private String image;

	@Column(name = "linkVideo")
	private String linkVideo;

	@Column(name = "date_event")
	private String date;

	@Column(name = "hour")
	private String hour;

	@Column(name = "place")
	private String place;

	@Column(name = "organizer")
	private String organizer;

	@OneToMany(mappedBy = "event")
	private List<VolunteeringEntity> volunteerings;

	public EventEntity() {

	}

	public EventEntity(int id, String name, String content, String image, String linkVideo, String date,
			String hour, String place, String organizer, List<VolunteeringEntity> volunteerings) {
		super();
		this.id = id;
		this.name = name;
		this.contentArticle = content;
		this.image = image;
		this.linkVideo = linkVideo;
		this.date = date;
		this.hour = hour;
		this.place = place;
		this.organizer = organizer;
		this.volunteerings = volunteerings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nom) {
		this.name = nom;
	}

	public String getContentArticle() {
		return contentArticle;
	}

	public void setContentArticle(String contentArticle) {
		this.contentArticle = contentArticle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLinkVideo() {
		return linkVideo;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public List<VolunteeringEntity> getVolunteerings() {
		return volunteerings;
	}

	public void setVolunteerings(List<VolunteeringEntity> volunteerings) {
		this.volunteerings = volunteerings;
	}

}
