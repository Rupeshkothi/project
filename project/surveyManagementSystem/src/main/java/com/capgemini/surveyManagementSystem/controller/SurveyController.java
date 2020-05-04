package com.capgemini.surveyManagementSystem.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.surveyManagementSystem.dao.AdminDAO;
import com.capgemini.surveyManagementSystem.dao.RespondentDAO;
import com.capgemini.surveyManagementSystem.dao.SurveyorDAO;
import com.capgemini.surveyManagementSystem.factory.Factory;
import com.capgemini.surveyManagementSystem.service.AdminService;
import com.capgemini.surveyManagementSystem.service.RespondentService;
import com.capgemini.surveyManagementSystem.service.SurveyorService;
import com.capgemini.surveyManagementSystem.validation.InputValidation;
import com.capgemini.surveyManagementSystem.validation.InputValidationImpl;

public class SurveyController {
	static final Logger logger = Logger.getLogger(SurveyController.class);

	public static void main(String[] args) {
		InputValidation inputValidation = new InputValidationImpl();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		do {
			logger.info("please tell who are you");
			logger.info("1.Admin login");
			logger.info("2.Surveyor login");
			logger.info("3.Respondent login");
			logger.info("4.Exit");
			String choice = sc.next();
			while (!inputValidation.choiceValidation(choice)) {
				logger.info("please enter valid choice");
				choice = sc.next();
			}
			int choice1 = Integer.parseInt(choice);

			switch (choice1) {

			case 1:
				logger.info("Enter User Name: ");
				String username = sc.next();
				logger.info("Enter password: ");
				String password = sc.next();
				AdminDAO adminDao = Factory.getAdminDAOInstance();
				if (adminDao.validateAdmin(username, password)) {
					AdminService.afterLogin();
				} else {
					logger.info("Login failed.\n");
					SurveyController.main(null);
				}
				break;
			case 2:
				logger.info("Enter User name: ");
				String username1 = sc.next();
				logger.info("Enter Password: ");
				String password1 = sc.next();
				SurveyorDAO surveyorDao = Factory.getSurveyorDAOInstance();
				if (surveyorDao.validateSurveyor(username1, password1)) {
					SurveyorService.surveydetails();
				} else {
					logger.info("Login failed.\n");
					SurveyController.main(null);
				}
				break;

			case 3:
				logger.info("Enter User name: ");
				String username2 = sc.next();
				logger.info("Enter Password: ");
				String password2 = sc.next();
				RespondentDAO respondentDao = Factory.getRespondentDAOInstance();
				if (respondentDao.validateRespondent(username2, password2)) {
					RespondentService respondentService = Factory.getRespondentServiceInstance();
					respondentService.respondentlist();
				} else {
					logger.info("Login failed.\n");
					SurveyController.main(null);
				}
				break;
			case 4:
				flag = false;
				logger.info("Exited!!");

				break;
			default:
				flag = false;
				logger.info("Select correct choice");
				break;
			}
		} while (!flag);
		sc.close();

	}
}
