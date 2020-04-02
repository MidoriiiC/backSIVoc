package fr.iutparis8.CSID.backSIVoc.Objets;

public class Utilisateur {

	private String nom;
	private String mdp;
	private int id;

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

	public Utilisateur() {

	}

	@Override
	public String toString() {
		String s = "id :" + this.getId() + " nom :" + this.getNom() + " mdp :" + this.getMdp();
		return s;
	}
}
