package com.avlview.data;

public class Getidlereport {

	String vid;
	String st_dt;
	String en_dt;

	public Getidlereport() {

	}

	public Getidlereport(String vid, String st_dt, String en_dt) {

		this.vid = vid;
		this.st_dt = st_dt;
		this.en_dt = en_dt;

	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getSt_dt() {
		return st_dt;
	}

	public void setSt_dt(String st_dt) {
		this.st_dt = st_dt;
	}

	public String getEn_dt() {
		return en_dt;
	}

	public void setEn_dt(String en_dt) {
		this.en_dt = en_dt;
	}

}
