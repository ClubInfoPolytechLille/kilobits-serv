package com.tbe.json;

public class Participe {

	private int id;
	private int nombre;
	private String evenement;
	private String utilisateur;

	public Participe(int id, int nombre, String evenement, String utilisateur) {
		this.id = id;
		this.nombre = nombre;
		this.evenement = evenement;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public String getEvenement() {
		return evenement;
	}

	public void setEvenement(String evenement) {
		this.evenement = evenement;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Participe() {

	}
}