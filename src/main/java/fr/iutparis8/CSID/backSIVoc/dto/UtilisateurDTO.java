package fr.iutparis8.CSID.backSIVoc.dto;

import fr.iutparis8.CSID.backSIVoc.enums.RoleEnum;

public class UtilisateurDTO {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private RoleEnum role;

	public int getId() {
		return this.id;
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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public UtilisateurDTO() {
	}

	public UtilisateurDTO(int id2) {
		this.id = id2;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
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
