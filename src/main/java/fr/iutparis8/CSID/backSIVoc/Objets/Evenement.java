package fr.iutparis8.CSID.backSIVoc.Objets;

public class Evenement {

	private int id;
	private String nom;
	private String contenuArticle;
	private String image;
	private String lienVideo;
	private String date, heure;
	private String lieu;
	private String organisateur;
	
	
	
	public Evenement(int id, String nom, String contenuArticle, String image, String lienVideo, String date,
			String heure, String lieu, String organisateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.contenuArticle = contenuArticle;
		this.image = image;
		this.lienVideo = lienVideo;
		this.date = date;
		this.heure = heure;
		this.lieu = lieu;
		this.organisateur = organisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getContenuArticle() {
		return contenuArticle;
	}

	public void setContenuArticle(String contenuArticle) {
		this.contenuArticle = contenuArticle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLienVideo() {
		return lienVideo;
	}

	public void setLienVideo(String lienVideo) {
		this.lienVideo = lienVideo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getOrganisateur() {
		return organisateur;
	}

	public void setOrganisateur(String organisateur) {
		this.organisateur = organisateur;
	}

	
}
