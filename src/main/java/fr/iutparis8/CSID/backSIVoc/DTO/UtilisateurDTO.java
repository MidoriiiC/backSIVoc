package fr.iutparis8.CSID.backSIVoc.DTO;

public class UtilisateurDTO {

	private int id;
	private String nom;
	private String mdp;
	
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
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
		this.id=id2;
	}
	
}
