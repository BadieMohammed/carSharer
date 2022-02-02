package de.unidue.inf.is.domain;

public class fahrerlaubnis {
	private String name;
	private int nummer ;
	public fahrerlaubnis () {}
	public fahrerlaubnis (String name , int nummer) {
		this.name = name;
		this.nummer=nummer;
	}
	public void setName(String name) {
		this.name = name ;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public String getName() {
		return name;
	}
	public int getNummer() {
		return nummer;
	}
	

}
