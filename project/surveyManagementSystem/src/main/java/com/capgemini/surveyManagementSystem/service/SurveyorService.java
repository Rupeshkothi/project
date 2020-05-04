package com.capgemini.surveyManagementSystem.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.surveyManagementSystem.beans.Surveyor;
import com.capgemini.surveyManagementSystem.dao.SurveyorDAO;
import com.capgemini.surveyManagementSystem.factory.Factory;
import com.capgemini.surveyManagementSystem.validation.InputValidation;

public class SurveyorService {
	static Logger logger = Logger.getLogger(SurveyorService.class);

	public boolean surveyorService() {
		SurveyorDAO surveyorDao = Factory.getSurveyorDAOInstance();
		surveyorDao.validateSurveyor("surveyor", "surveyor");
		return true;
	}

	public static boolean surveydetails() {
		InputValidation inputValidation = Factory.getInputValidationInstance();
		Surveyor surveyor = Factory.getSurveyorInstance();
		logger.info("Enter 1 to create survey");
		logger.info("Enter 2 to edit survey");
		logger.info("Enter 3 to delete survey");
		logger.info("Enter 4 to List all surveys");
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();
		while (!inputValidation.choiceValidation(choice)) {
			System.out.println("please enter valid choice");
			choice = sc.nextLine();
		}
		int choice1 = Integer.parseInt(choice);

		switch (choice1) {

		case 1:
			SurveyorDAO surveyorDao1 = Factory.getSurveyorDAOInstance();
			surveyorDao1.createSurvey(surveyor);
			surveydetails();
			break;
		case 2:
			SurveyorDAO surveyorDao2 = Factory.getSurveyorDAOInstance();
			surveyorDao2.editSurvey(surveyor);
			surveydetails();
			break;

		case 3:
			SurveyorDAO surveyorDao3 = Factory.getSurveyorDAOInstance();
			surveyorDao3.deleteSurvey("surveyTitle");
			surveydetails();
			break;
		case 4:
			SurveyorDAO surveyorDao4 = Factory.getSurveyorDAOInstance();
			surveyorDao4.getAllSurveys();
			surveydetails();
			break;
		}
		sc.close();
		return false;
	}
}