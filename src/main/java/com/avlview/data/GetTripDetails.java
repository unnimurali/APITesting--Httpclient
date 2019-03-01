package com.avlview.data;

public class GetTripDetails {

	String vehicle_id;
	String trip_date;

	public GetTripDetails() {

	}

	public GetTripDetails(String vehicle_id, String trip_date) {

		this.vehicle_id = vehicle_id;
		this.trip_date = trip_date;

	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getTrip_date() {
		return trip_date;
	}

	public void setTrip_date(String trip_date) {
		this.trip_date = trip_date;
	}

}
