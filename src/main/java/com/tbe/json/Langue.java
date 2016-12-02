package com.tbe.json;

public class Langue {
	private int id;
	private String langue;

	public int getId() {
		return id;
	}

	public Langue() {
	}

	public Langue(int id, String langue) {
		this.id = id;
		this.langue = langue;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}
}
