package com.oop.model;

public class Admin {
	
	private String aId;
	private String aName;
	private String aEmail;
	private String aPhone;
	private String aPassword;
	
	public Admin(String aId, String aName, String aEmail, String aPhone, String aPassword) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aEmail = aEmail;
		this.aPhone = aPhone;
		this.aPassword = aPassword;
	}
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaEmail() {
		return aEmail;
	}
	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}
	public String getaPhone() {
		return aPhone;
	}
	public void setaPhone(String aPhone) {
		this.aPhone = aPhone;
	}
	public String getaPassword() {
		return aPassword;
	}
	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}
		
}
