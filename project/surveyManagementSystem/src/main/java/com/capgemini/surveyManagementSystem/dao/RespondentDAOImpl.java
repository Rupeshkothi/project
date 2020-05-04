package com.capgemini.surveyManagementSystem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.surveyManagementSystem.beans.Respondent;
import com.capgemini.surveyManagementSystem.beans.Result;
import com.capgemini.surveyManagementSystem.beans.Survey;
import com.capgemini.surveyManagementSystem.exception.SurveyNotFoundException;
import com.capgemini.surveyManagementSystem.factory.Factory;
import com.capgemini.surveyManagementSystem.validation.InputValidation;

public class RespondentDAOImpl implements RespondentDAO {
	Respondent respondent1 = null;

	public RespondentDAOImpl() {
		respondent1 = Factory.getRespondentInstance();
		respondent1.setUsername("respondent");
		respondent1.setPassword("respondent");
	}

	public boolean validateRespondent(String username, String password) {
		if (username.contentEquals(respondent1.getUsername()) && password.equals(respondent1.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	static final Logger logger = Logger.getLogger(RespondentDAOImpl.class);
	InputValidation inputValidation = Factory.getInputValidationInstance();
	public static ArrayList<Respondent> respondent = new ArrayList<Respondent>();
	Result result = Factory.getResultInstance();
	public static ArrayList<Result> surveyresult = new ArrayList<Result>();
	Survey survey = Factory.getSurveyInstance();
	Scanner sc = new Scanner(System.in);
	int count = 0;

	@SuppressWarnings("unused")
	public boolean respondList() {
		logger.info("Enter the survey ");
		String survey2 = sc.next();
		for (Survey survey : SurveyorDAOImpl.surveytitle) {
			if (survey.getSurveyTitle().contentEquals(survey2)) {
				count++;
				logger.info(" Enter the " + survey.getQ1());
				logger.info(" enter answer for question 1");
				String result1 = new String();
				result1 = sc.next();
				logger.info(" Enter the " + survey.getQ2());
				logger.info(" enter answer for question 2");
				String result2 = new String();
				result2 = sc.next();
				logger.info("Enter the " + survey.getQ3());
				logger.info(" enter answer for question 3");
				String result3 = new String();
				result3 = sc.next();
				logger.info("Enter the " + survey.getQ4());
				logger.info(" enter answer for question 4");
				String result4 = new String();
				result4 = sc.next();
				logger.info("Enter the " + survey.getQ5());
				logger.info(" enter answer for question 5");
				String result5 = new String();
				result5 = sc.next();
				ArrayList<Result> List = new ArrayList<Result>();
				List.add(result);
				surveyresult.addAll(List);
			}
		}
		try {
			if (count == 0) {
				throw new SurveyNotFoundException("Survey not found");
			}
		} catch (SurveyNotFoundException e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	public List<Result> viewrespondlist() {
		// TODO Auto-generated method stub
		logger.info("Responded  surveys: ");
		for (Result result : surveyresult) {
			if (surveyresult.isEmpty()) {
				logger.info("Response is not recorded");
			} else {
				logger.info(result);
			}
		}
		return surveyresult;
	}

}
