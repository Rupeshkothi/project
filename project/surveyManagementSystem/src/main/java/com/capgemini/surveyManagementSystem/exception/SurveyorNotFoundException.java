package com.capgemini.surveyManagementSystem.exception;

import org.apache.log4j.Logger;

public class SurveyorNotFoundException extends RuntimeException{
	String message;
	public org.apache.log4j.Logger logger=Logger.getLogger(SurveyorNotFoundException.class);
	public SurveyorNotFoundException(String message) {
		this.message=message;
		logger.error(message);
	}
}
