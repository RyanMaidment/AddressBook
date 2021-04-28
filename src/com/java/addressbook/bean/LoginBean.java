package com.java.addressbook.bean;

public class LoginBean {
 
    private String userName;
    private String password;
    private int id;
    private boolean manager;
 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
    public String getUserName() {
    return userName;
    }
    public void setUserName(String userName) {
    this.userName = userName;
    }
    public String getPassword() {
    return password;
    }
    public void setPassword(String password) {
    this.password = password;
    }
    
    public boolean getManager() {
    	return manager;
    }
    
    public void setManager(Boolean manager) {
    	this.manager = manager;
    }
}