package org.mql.java.informations;

public class Livres extends Author {
   
	private String Title;
	private int code;
	public Livres(String Title, int code) {
		this.code = code;
		this.Title = Title;
	}

}
