package com.oop.model;

public class Vehicle {
	private String vId;
	private String model;
	private String registrationNo;
	private String type;
	private String seat;
	
	public Vehicle(String vId, String model, String registrationNo, String type, String seat) {
		super();
		this.vId = vId;
		this.model = model;
		this.registrationNo = registrationNo;
		this.type = type;
		this.seat = seat;
	}
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public String getvId() {
		return vId;
	}
	public void setvId(String vId) {
		this.vId = vId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
}
