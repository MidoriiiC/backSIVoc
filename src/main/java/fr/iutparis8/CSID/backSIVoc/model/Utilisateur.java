package fr.iutparis8.CSID.backSIVoc.model;

import fr.iutparis8.CSID.backSIVoc.enums.RoleEnum;

public class Utilisateur{

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	private RoleEnum role;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utilisateur() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMdp() {
		return motDePasse;
	}

	public void setMdp(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public void setRole(RoleEnum r) {
		this.role = r;
	}
	public RoleEnum getRole() {
		return this.role;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
