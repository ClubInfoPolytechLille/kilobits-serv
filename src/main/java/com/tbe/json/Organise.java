package com.tbe.json;

public class Organise {

	private int id;
	private String evenement;
	private String utilisateur;

	public Organise(int id, String evenement, String utilisateur) {
		this.id = id;
		this.evenement = evenement;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Organise() {

	}
}