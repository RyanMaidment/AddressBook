package com.java.addressbook.bean;

public class ContactBean {
	private Long id;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String email;
	private String address;
	private Byte isClassified;
	
	public ContactBean() {
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Byte getIsClassified() {
		return isClassified;
	}
	public void setIsClassified(Byte isClassified) {
		this.isClassified = isClassified;
	}
}
