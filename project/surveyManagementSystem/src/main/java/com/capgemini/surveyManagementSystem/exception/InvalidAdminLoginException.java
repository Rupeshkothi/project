package com.capgemini.surveyManagementSystem.exception;

@SuppressWarnings("serial")
public class InvalidAdminLoginException extends RuntimeException {
	String message = "Admin  not found";

	public InvalidAdminLoginException() {

	}

	public InvalidAdminLoginException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
