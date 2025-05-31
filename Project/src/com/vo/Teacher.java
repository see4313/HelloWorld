package com.vo;

public class Teacher {
	private String name;
	private String phone;
	private String gender;
	
	

	public Teacher() {}
	public Teacher(String name, String phone, String gender) {
		super();
		this.name = name;
		this.phone = phone;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}



}
