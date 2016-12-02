package com.tbe.json;

public class Service {

	private int id;
	private String idcategorie;
	private String idutilisateur;

	public Service(int id, String idcategorie, String idutilisateur) {
		this.id = id;
		this.idcategorie = idcategorie;
		this.idutilisateur = idutilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdcategorie() {
		return idcategorie;
	}

	public void setIdcategorie(String idcategorie) {
		this.idcategorie = idcategorie;
	}

	public String getIdutilisateur() {
		return idutilisateur;
	}

	public void setIdutilisateur(String idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public Service() {

	}
}