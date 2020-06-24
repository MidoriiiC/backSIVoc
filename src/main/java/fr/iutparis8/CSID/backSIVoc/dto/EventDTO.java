package fr.iutparis8.CSID.backSIVoc.dto;

import java.util.List;

public class EventDTO {

	private int id;
	private String name;
	private String contentArticle;
	private String image;
	private String linkVideo;
	private String date, hour;
	private String place;
	private String organizer;
	private List<VolunteeringDTO> volunteerings;

	public EventDTO() {

	}

	public EventDTO(int id, String name, String contentArticle, String image, String linkVideo, String date,
			String hour, String place, String organizer, List<VolunteeringDTO> volunteerings) {
		super();
		this.id = id;
		this.name = name;
		this.contentArticle = contentArticle;
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

	public void setName(String name) {
		this.name = name;
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

	public List<VolunteeringDTO> getVolunteerings() {
		return volunteerings;
	}

	public void setVolunteerings(List<VolunteeringDTO> volunteerings) {
		this.volunteerings = volunteerings;
	}

}
