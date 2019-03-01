package com.avlview.data;

public class Vehicleoverviewbyplan {

	String e_service_plan_id;
	String e_service_country_id;

	public Vehicleoverviewbyplan() {

	}

	public Vehicleoverviewbyplan(String e_service_plan_id, String e_service_country_id) {
		this.e_service_plan_id = e_service_plan_id;
		this.e_service_country_id = e_service_country_id;

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

}
