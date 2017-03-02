package com.tbe.json;


import java.io.Serializable;


public class User implements Serializable {

    private int id;
	private String pseudo;
	private String nom;
	private String prenom;
	private String mdp;
	private int ville;
	private boolean estMobile;
	private boolean typ;
	private String divers;
	private boolean dispo;

	//Must have empty constructor
    public User(){}

	public User(String pseudo, String nom, String prenom, String mdp, int ville, boolean estMobile, boolean typ, String divers, boolean dispo) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.ville = ville;
		this.estMobile = estMobile;
		this.typ = typ;
		this.divers = divers;
		this.dispo = dispo;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getVille() {
        return ville;
    }

    public void setVille(int ville) {
        this.ville = ville;
    }

    public boolean isEstMobile() {
        return estMobile;
    }

    public void setEstMobile(boolean estMobile) {
        this.estMobile = estMobile;
    }

    public boolean isTyp() {
        return typ;
    }

    public void setTyp(boolean typ) {
        this.typ = typ;
    }

    public String getDivers() {
        return divers;
    }

    public void setDivers(String divers) {
        this.divers = divers;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }
}
