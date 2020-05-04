package com.capgemini.surveyManagementSystem.exception;

import org.apache.log4j.Logger;

public class SurveyNotFoundException extends RuntimeException {

	public SurveyNotFoundException(String message) {
		org.apache.log4j.Logger logger = Logger.getLogger(SurveyNotFoundException.class);
		logger.error(message);
	}

	// TODO Auto-generated constructor stub
}
