package com.pratian.onlineexamapp.models;

public class AdminPassword {
	private String userName;
	private String password;
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
	public AdminPassword(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminPassword [userName=" + userName + ", password=" + password + "]";
	}
	public AdminPassword() {
		super();
	}
	
	
	
}
