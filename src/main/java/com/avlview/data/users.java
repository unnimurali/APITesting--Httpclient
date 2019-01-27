package com.avlview.data;

public class users {
	
	String name;
	String job;
	String id;
	String CreatedAT;
	
	public users()
	{}
	
	public users(String name,String job)
	{
		this.name=name;
		this.job=job;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatedAT() {
		return CreatedAT;
	}
	public void setCreatedAT(String createdAT) {
		CreatedAT = createdAT;
	}
	
	

}
