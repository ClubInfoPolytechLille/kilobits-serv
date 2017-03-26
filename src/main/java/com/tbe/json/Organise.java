package com.tbe.json;

public class Organise {

    private int evenement;
    private int utilisateur;

    public Organise(int evenement, int utilisateur) {
        this.evenement = evenement;
        this.utilisateur = utilisateur;
    }

    public Organise() {
    }

    public int getEvenement() {
        return evenement;
    }

    public void setEvenement(int evenement) {
        this.evenement = evenement;
    }

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }
}