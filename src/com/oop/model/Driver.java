package com.oop.model;

public class Driver {
	private String dId;
	private String dName;
	private String dPhone;
	private String dAddress;
	public String getdId() {
		return dId;
	}
	
	public Driver(String dId, String dName, String dPhone, String dAddress) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dPhone = dPhone;
		this.dAddress = dAddress;
	}
	
	public Driver() {
		
	}

	public void setdId(String dId) {
		this.dId = dId;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getdPhone() {
		return dPhone;
	}
	public void setdPhone(String dPhone) {
		this.dPhone = dPhone;
	}
	public String getdAddress() {
		return dAddress;
	}
	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
	}
	
}
