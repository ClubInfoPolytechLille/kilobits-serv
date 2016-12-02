package com.tbe.json;

import java.sql.Date;

public class Evenement {

	private int id;
	private String lieu;
	private String description;

	public Evenement(int id, String lieu, Date dat, String description) {
		this.id = id;
		this.lieu = lieu;
		this.dat = dat;
		this.description = description;
	}

	public Evenement() {

	}

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDat() {
		return dat;
	}

	public void setDat(Date dat) {
		this.dat = dat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
