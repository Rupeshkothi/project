package com.capgemini.surveyManagementSystem.beans;

public class Surveyor {
	private String username;
	private String password;
	private String emailId;
	private Long phoneNo;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Surveyor [username=" + username + ", password=" + password + ", emailId=" + emailId + ", phoneNo="
				+ phoneNo + "]";
	}

}