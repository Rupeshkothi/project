package com.capgemini.surveyManagementSystem.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.capgemini.surveyManagementSystem.beans.Respondent;
import com.capgemini.surveyManagementSystem.beans.Survey;
import com.capgemini.surveyManagementSystem.beans.Surveyor;
import com.capgemini.surveyManagementSystem.exception.SurveyNotFoundException;
import com.capgemini.surveyManagementSystem.factory.Factory;
import com.capgemini.surveyManagementSystem.validation.InputValidation;

public class SurveyorDAOImpl implements SurveyorDAO {
	Surveyor surveyor = null;

	public SurveyorDAOImpl() {
		surveyor = Factory.getSurveyorInstance();
		surveyor.setUsername("surveyor");
		surveyor.setPassword("surveyor");
	}

	public boolean validateSurveyor(String username, String password) {
		if (username.contentEquals(surveyor.getUsername()) && password.equals(surveyor.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	public static Logger logger = Logger.getLogger(SurveyorDAOImpl.class);
	InputValidation inputValidation = Factory.getInputValidationInstance();
	Surveyor surveyor1 = Factory.getSurveyorInstance();
	public static List<Survey> survey = new ArrayList<Survey>();
	static List<Survey> surveytitle = new ArrayList<Survey>();
	int count = 0;
	Scanner sc = new Scanner(System.in);
	static {
		Survey survey1 = Factory.getSurveyInstance();
		survey1.setSurveyTitle("Amazon");
		survey1.setSurveyDescription("Phone");
		survey1.setQ4("Phone brand ?");
		survey1.setQ2("Model no of Phone ?");
		survey1.setQ3("Back Camera Pixels ?");
		survey1.setQ4("Internal Memory of phone ?");
		survey1.setQ5("Cost Price ?");
		surveytitle.add(survey1);
		survey.addAll(surveytitle);
	}

	public void addQuestions() {
		Survey survey = Factory.getSurveyInstance();
		logger.info("Enter Question no 1: ");
		String q1 = sc.next();
		survey.setQ1(q1);
		logger.info("Enter Question no 2: ");
		String q2 = sc.next();
		survey.setQ2(q2);
		logger.info("Enter Question no 3: ");
		String q3 = sc.next();
		survey.setQ3(q3);
		logger.info("Enter Question no 4: ");
		String q4 = sc.next();
		survey.setQ4(q4);
		logger.info("Enter Question no 5: ");
		String q5 = sc.next();
		survey.setQ5(q5);
	}

	public boolean createSurvey(Surveyor surveyor) {
		// TODO Auto-generated method stub
		InputValidation inputValidation = Factory.getInputValidationInstance();
		Survey survey = Factory.getSurveyInstance();
		logger.info("Enter Survey Title");
		String survey1 = sc.next();
		while (!inputValidation.surveyTitleValidation(survey1)) {
			logger.info("Please enter valid Survey Title");
			survey1 = sc.next();
		}

		logger.info("Enter Survey Description");
		String surveyDescription = sc.next();
		while (!inputValidation.surveyDescriptionValidation(survey1)) {
			logger.info("Please enter valid Survey Description");
			surveyDescription = sc.next();
		}
		logger.info("Enter E-MailId ");
		String email = sc.next();
		while (!inputValidation.emailValidation(email)) {
			logger.info("Please enter valid E-MailId");
			email = sc.next();
		}
		logger.info("enter your contact number ");
		String phoneNo = sc.next();
		while (!inputValidation.mobileNoValidation(phoneNo)) {
			logger.info("Moblie number start from 6-9 and enter 10numbers");
			phoneNo = sc.next();
		}
		Long phonenum = Long.parseLong(phoneNo);
		survey.setSurveyTitle(survey1);
		survey.setSurveyDescription(surveyDescription);
		surveyor.setEmailId(email);
		surveyor.setPhoneNo(phonenum);
		addQuestions();
		ArrayList<Survey> List = new ArrayList<Survey>();
		List.add(survey);
		surveytitle.addAll(List);
		if (List.isEmpty()) {
			logger.info("survey  not added");
			return false;

		} else {
			logger.info("survey is added");
			return true;
		}
	}

	public boolean editSurvey(Surveyor surveyor) {
		// TODO Auto-generated method stub
		InputValidation inputValidation = Factory.getInputValidationInstance();
		logger.info("Enter Survey Title");
		String survey1 = sc.next();
		while (!inputValidation.surveyTitleValidation(survey1)) {
			logger.info("Please Enter valid SurveyTitle");
			survey1 = sc.next();
		}
		for (Survey survey : surveytitle) {
			if (survey.getSurveyTitle().contentEquals(survey1)) {
				count++;
				logger.info("updating");

				logger.info("Enter  new Survey Title");
				String survey11 = sc.next();
				while (!inputValidation.surveyTitleValidation(survey11)) {
					logger.info("Please enter valid Survey Title");
					survey11 = sc.next();
				}
				logger.info("Enter New Survey Description");
				String surveyDescription = sc.next();
				while (!inputValidation.surveyDescriptionValidation(surveyDescription)) {
					logger.info("please enter valid description");
					surveyDescription = sc.next();
				}
				survey.setSurveyTitle(survey11);
				survey.setSurveyDescription(surveyDescription);
				addQuestions();
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

	public boolean deleteSurvey(String surveyTitle) {
		// TODO Auto-generated method stub
		InputValidation inputValidation = Factory.getInputValidationInstance();
		logger.info("enter survey Title");
		String survey = sc.next();
		while (!inputValidation.surveyTitleValidation(survey)) {
			logger.info("please enter valid SurveyTitle");
			survey = sc.next();
		}
		Iterator<Survey> survey1 = surveytitle.iterator();
		while (survey1.hasNext()) {

			Survey survey2 = survey1.next();

			if (survey2.getSurveyTitle().contentEquals(survey)) {
				count++;
				survey1.remove();
			}
		}
		try {
			if (count == 0) {
				throw new SurveyNotFoundException("Survey not found");
			} else {
				logger.info("suvery deleted");
			}
		} catch (SurveyNotFoundException e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	public List<Survey> getAllSurveys() {
		// TODO Auto-generated method stub
		logger.info("list of survey");

		for (Survey survey : surveytitle) {
			logger.info(survey);
		}
		return surveytitle;

	}

	public void distributeSurvey() {
		Respondent respondent = new Respondent();
		RespondentDAO respondentDao = new RespondentDAOImpl();
		respondentDao.validateRespondent("respondent", "respondent");
		logger.info("Enter Respondent name: ");
		String username = sc.next();
		logger.info("Enter Password: ");
		String password = sc.next();
		if (username.equals(respondent.getUsername()) && password.equals(respondent.getPassword())) {
			logger.info("Enter SurveyTitle: ");

		}

	}

}
