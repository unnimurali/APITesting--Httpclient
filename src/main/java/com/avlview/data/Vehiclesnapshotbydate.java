package com.avlview.data;

public class Vehiclesnapshotbydate {

	String vehicle_id;
	String date_time;

	public Vehiclesnapshotbydate() {

	}

	public Vehiclesnapshotbydate(String vehicle_id, String date_time) {

		this.vehicle_id = vehicle_id;
		this.date_time = date_time;

	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

}
