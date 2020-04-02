package fr.iutparis8.CSID.backSIVoc.Objets;

public class Authentification {
	
	private String nom;
	private int id;
	private String mdp;
	
	public Authentification() {
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
