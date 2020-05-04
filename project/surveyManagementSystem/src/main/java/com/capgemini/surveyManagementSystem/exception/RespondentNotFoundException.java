package com.capgemini.surveyManagementSystem.exception;

public class RespondentNotFoundException extends RuntimeException {
	String message="Respondent  not found";
	public RespondentNotFoundException() {
			
		}
		public RespondentNotFoundException(String message) {
			super();
			this.message = message;
		}
		public String getMessage() {
			return message;	
		}


}
