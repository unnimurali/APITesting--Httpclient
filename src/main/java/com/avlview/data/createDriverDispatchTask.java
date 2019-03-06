package com.avlview.data;

public class createDriverDispatchTask {

	String task_id;
	String driver_id;
	String group_code;
	String task_desc;
	String task_dt;
	String task_f_desc;
	String contact_code;
	String contact_name;
	String email;
	String isd_code;
	String mobile;
	String lat;
	String lon;
	String contact_location;

	public createDriverDispatchTask() {

	}

	public createDriverDispatchTask(String task_id, String driver_id, String group_code, String task_desc,
			String task_dt, String task_f_desc, String contact_code, String contact_name, String email, String isd_code,
			String mobile, String lat, String lon, String contact_location) {

		this.task_id = task_id;
		this.driver_id = driver_id;
		this.group_code = group_code;
		this.task_desc = task_desc;
		this.task_dt = task_dt;
		this.task_f_desc = task_f_desc;
		this.contact_code = contact_code;
		this.contact_name = contact_name;
		this.email = email;
		this.isd_code = isd_code;
		this.mobile = mobile;
		this.lat = lat;
		this.lon = lon;
		this.contact_location = contact_location;

	}

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}

	public String getGroup_code() {
		return group_code;
	}

	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}

	public String getTask_desc() {
		return task_desc;
	}

	public void setTask_desc(String task_desc) {
		this.task_desc = task_desc;
	}

	public String getTask_dt() {
		return task_dt;
	}

	public void setTask_dt(String task_dt) {
		this.task_dt = task_dt;
	}

	public String getTask_f_desc() {
		return task_f_desc;
	}

	public void setTask_f_desc(String task_f_desc) {
		this.task_f_desc = task_f_desc;
	}

	public String getContact_code() {
		return contact_code;
	}

	public void setContact_code(String contact_code) {
		this.contact_code = contact_code;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsd_code() {
		return isd_code;
	}

	public void setIsd_code(String isd_code) {
		this.isd_code = isd_code;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getContact_location() {
		return contact_location;
	}

	public void setContact_location(String contact_location) {
		this.contact_location = contact_location;
	}

}
