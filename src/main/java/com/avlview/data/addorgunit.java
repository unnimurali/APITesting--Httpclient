package com.avlview.data;

public class addorgunit {

	String org_unit_name;
	String puid;
	String start_hours;
	String start_minutes;
	String end_hours;
	String end_minutes;

	public addorgunit() {

	}

	public addorgunit(String org_unit_name, String puid, String start_hours, String start_minutes, String end_hours,
			String end_minutes) {

		this.org_unit_name = org_unit_name;
		this.puid = puid;
		this.start_hours = start_hours;
		this.start_minutes = start_minutes;
		this.end_hours = end_hours;
		this.end_minutes = end_minutes;

	}

	public String getOrg_unit_name() {
		return org_unit_name;
	}

	public void setOrg_unit_name(String org_unit_name) {
		this.org_unit_name = org_unit_name;
	}

	public String getPuid() {
		return puid;
	}

	public void setPuid(String puid) {
		this.puid = puid;
	}

	public String getStart_hours() {
		return start_hours;
	}

	public void setStart_hours(String start_hours) {
		this.start_hours = start_hours;
	}

	public String getStart_minutes() {
		return start_minutes;
	}

	public void setStart_minutes(String start_minutes) {
		this.start_minutes = start_minutes;
	}

	public String getEnd_hours() {
		return end_hours;
	}

	public void setEnd_hours(String end_hours) {
		this.end_hours = end_hours;
	}

	public String getEnd_minutes() {
		return end_minutes;
	}

	public void setEnd_minutes(String end_minutes) {
		this.end_minutes = end_minutes;
	}

}
