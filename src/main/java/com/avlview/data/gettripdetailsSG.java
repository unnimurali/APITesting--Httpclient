package com.avlview.data;

public class gettripdetailsSG {

	String vid;
	String st_dt;
	String en_dt;
	String uid;
	String ug_id;
	String sp_id;
	String sc_id;

	public gettripdetailsSG() {

	}

	public gettripdetailsSG(String vid, String st_dt, String en_dt, String uid, String ug_id, String sp_id,
			String sc_id) {
		this.vid = vid;
		this.st_dt = st_dt;
		this.en_dt = en_dt;
		this.uid = uid;
		this.ug_id = ug_id;
		this.sp_id = sp_id;
		this.sc_id = sc_id;
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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUg_id() {
		return ug_id;
	}

	public void setUg_id(String ug_id) {
		this.ug_id = ug_id;
	}

	public String getSp_id() {
		return sp_id;
	}

	public void setSp_id(String sp_id) {
		this.sp_id = sp_id;
	}

	public String getSc_id() {
		return sc_id;
	}

	public void setSc_id(String sc_id) {
		this.sc_id = sc_id;
	}

}
