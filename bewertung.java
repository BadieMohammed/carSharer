package de.unidue.inf.is.domain;

import java.sql.Date;

public class bewertung {
	private int id;
	private String text;
	private long datum;
	private int rate;
	
	public bewertung() {}
	public bewertung(int id , String text , long datum , int rate) {
		this.id=id;
		this.text=text;
		this.datum=datum;
		this.rate=rate;
	}
	public bewertung(String text , long datum , int rate) {
		this.text=text;
		this.datum=datum;
		this.rate=rate;
	}
	public void setID(int id) {
		this.id=id;
	}
	public void setText(String text) {
		this.text=text;
	}
	public void setDatum(long datum) {
		this.datum=datum;
	}
	public void setRate(int rate) {
		this.rate=rate;
	}
	public int getID() {
		return id;
	}
	public String getText() {
		return text;
	}
	public long getDatum() {
		return datum;
	}
	public int getRate() {
		return rate;
	}

}
