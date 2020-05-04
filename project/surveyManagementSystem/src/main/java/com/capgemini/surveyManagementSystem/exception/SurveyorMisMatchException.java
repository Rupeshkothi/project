package com.capgemini.surveyManagementSystem.exception;

import org.apache.log4j.Logger;

public class SurveyorMisMatchException extends RuntimeException {
	public SurveyorMisMatchException(String message) {
		org.apache.log4j.Logger logger = Logger.getLogger(SurveyNotFoundException.class);
		logger.error(message);
	}
}
