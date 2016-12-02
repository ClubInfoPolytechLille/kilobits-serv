package com.tbe.json;

public class Message {

	private int id;
	private String texte;
	private int idUtilisateur;

	public Message() {
	}

	public Message(int id, String texte, int idUtilisateur) {
		this.id = id;
		this.texte = texte;
		this.idUtilisateur = idUtilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
}
