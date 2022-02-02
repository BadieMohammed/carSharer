package de.unidue.inf.is.domain;

public class fahrt {
	private int fid;
	private String start;
	private String ziel;
	private long zeit;
	private int maxplaetze;
	private int fahrkosten;
	private String status;
	private String anbieter;
	private String tmittle;
	private String beschreibung;
	public fahrt() {}
	public fahrt (int fid, String start , String ziel , long zeit , int maxp, int fahrkosten , String status , String anbieter, String tmittel , String beschreibung ) {
	    this.fid=fid;
	    this.start=start;
	    this.ziel=ziel;
	    this.zeit=zeit;
	    this.maxplaetze=maxp;
	    this.fahrkosten=fahrkosten;
	    this.status=status;
	    this.anbieter=anbieter;
	    this.tmittle=tmittel;
	    this.beschreibung=beschreibung;
	}
	public fahrt (String start , String ziel , Long zeit , int maxp, int fahrkosten , String anbieter, String tmittel , String beschreibung ) { 
	    this.start=start;
	    this.ziel=ziel;
	    this.zeit=zeit;
	    this.maxplaetze=maxp;
	    this.fahrkosten=fahrkosten;
	    this.anbieter=anbieter;
	    this.tmittle=tmittel;
	    this.beschreibung=beschreibung;
	}
	public void setID(int fid) {
		this.fid=fid;
	}
	public void setStart(String start) {
		this.start=start;
	}
	public void setZiel(String ziel) {
		this.ziel=ziel;
	}
	public void setZeit(long zeit) {
		this.zeit=zeit;
	}
	public void setMax(int maxp) {
		this.maxplaetze=maxp;
	}
	public void setFahrkosten(int fahrKosten) {
		this.fahrkosten=fahrKosten;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	public void setAnbieter(String anbieter) {
		this.anbieter=anbieter;
	}
	public void setTransportmittle(String tmittle) {
		this.tmittle=tmittle;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung=beschreibung;
	}
	public int getID() {
		return fid;
	}
	public String getStart() {
		return start;
	}
	public String getZiel() {
		return ziel;
	}
	public long getZeit() {
		return zeit;
	}
	public int getMaxPlaetze() {
		return maxplaetze;
	}
	public int getFahrKosten() {
		return fahrkosten;
	}	
	public String getStatus() {
		return status;
	}
	public String getAnbieter() {
		return anbieter;
	}
	public String getMittle() {
		return tmittle;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
}
