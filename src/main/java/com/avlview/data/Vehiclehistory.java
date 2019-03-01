package com.avlview.data;

public class Vehiclehistory {

	String vehicle_id;
	String sdate_time;
	String edate_time;

	public Vehiclehistory() {

	}

	public Vehiclehistory(String vehicle_id, String sdate_time, String edate_time) {

		this.vehicle_id = vehicle_id;
		this.sdate_time = sdate_time;
		this.edate_time = edate_time;

	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getSdate_time() {
		return sdate_time;
	}

	public void setSdate_time(String sdate_time) {
		this.sdate_time = sdate_time;
	}

	public String getEdate_time() {
		return edate_time;
	}

	public void setEdate_time(String edate_time) {
		this.edate_time = edate_time;
	}

}
