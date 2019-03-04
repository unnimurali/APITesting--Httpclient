package com.avlview.data;

public class adddriver {

	String driver_name;
	String mobile;
	String ibutton;
	String license_num;
	String license_exp;

	public adddriver() {

	}

	public adddriver(String driver_name, String mobile, String ibutton, String license_num, String license_exp) {
		this.driver_name = driver_name;
		this.mobile = mobile;
		this.ibutton = ibutton;
		this.license_num = license_num;
		this.license_exp = license_exp;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIbutton() {
		return ibutton;
	}

	public void setIbutton(String ibutton) {
		this.ibutton = ibutton;
	}

	public String getLicense_num() {
		return license_num;
	}

	public void setLicense_num(String license_num) {
		this.license_num = license_num;
	}

	public String getLicense_exp() {
		return license_exp;
	}

	public void setLicense_exp(String license_exp) {
		this.license_exp = license_exp;
	}

}
