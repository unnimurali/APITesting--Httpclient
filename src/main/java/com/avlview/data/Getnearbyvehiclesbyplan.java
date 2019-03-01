package com.avlview.data;

public class Getnearbyvehiclesbyplan {
	String e_service_plan_id;
	String e_service_country_id;
	String lon;
	String lat;
	String buffer;

	public Getnearbyvehiclesbyplan() {

	}

	public Getnearbyvehiclesbyplan(String e_service_plan_id, String e_service_country_id, String lon, String lat,
			String buffer) {

		this.e_service_plan_id = e_service_plan_id;
		this.e_service_country_id = e_service_country_id;
		this.lon = lon;
		this.lat = lat;
		this.buffer = buffer;

	}

	public String getE_service_plan_id() {
		return e_service_plan_id;
	}

	public void setE_service_plan_id(String e_service_plan_id) {
		this.e_service_plan_id = e_service_plan_id;
	}

	public String getE_service_country_id() {
		return e_service_country_id;
	}

	public void setE_service_country_id(String e_service_country_id) {
		this.e_service_country_id = e_service_country_id;
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
