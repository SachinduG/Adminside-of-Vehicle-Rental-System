package com.oop.model;

public class Customer {
	private String cId;
	private String cName;
	private String cPhone;
	private String cEmail;
	private String cAddress;
	
	public Customer(String cId, String cName, String cPhone, String cEmail, String cAddress) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cPhone = cPhone;
		this.cEmail = cEmail;
		this.cAddress = cAddress;
	}

	public Customer() {

	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	
	
	
}
