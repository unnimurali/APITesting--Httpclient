package com.avlview.data;

public class Getnearbyvehicles {

	String lon;
	String lat;
	String buffer;

	public Getnearbyvehicles() {

	}

	public Getnearbyvehicles(String lon, String lat, String buffer) {

		this.lon = lon;
		this.lat = lat;
		this.buffer = buffer;

	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getBuffer() {
		return buffer;
	}

	public void setBuffer(String buffer) {
		this.buffer = buffer;
	}

}
