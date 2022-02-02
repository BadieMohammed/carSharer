package de.unidue.inf.is.domain;

public class transportmittel {
	private int tid ;
	private String name ;
	private String icon ;
	public transportmittel() {}
	public transportmittel (int tid , String name , String icon) {
		this.tid=tid;
		this.name=name;
		this.icon=icon;
	}
	public void setID(int id) {
		this.tid=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setIcon(String icon) {
		this.icon=icon;
	}
	public int getID() {
		return tid;
	}
	public String getName() {
		return name;
	}
	public String getIcon () {
		return icon;
	}
	}
