package com.capgemini.surveyManagementSystem.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.surveyManagementSystem.controller.SurveyController;
import com.capgemini.surveyManagementSystem.dao.AdminDAO;
import com.capgemini.surveyManagementSystem.dao.RespondentDAO;
import com.capgemini.surveyManagementSystem.dao.SurveyorDAO;
import com.capgemini.surveyManagementSystem.factory.Factory;
import com.capgemini.surveyManagementSystem.validation.InputValidation;

public class AdminService {
	static Scanner sc= new Scanner(System.in);
	static Logger logger=Logger.getLogger(AdminService.class);
	
	public boolean adminService() {
		AdminDAO adminDao=Factory.getAdminDAOInstance();
		adminDao.validateAdmin("admin", "admin");
		return true;
	}
	public static  boolean afterLogin() {
		InputValidation inputValidation=Factory.getInputValidationInstance();
		boolean flag;
		logger.info("Logged in as Admin ");
		do {
			flag=true;
		logger.info("Enter your Choice ");
		logger.info("Enter 1 to Login as Surveyor ");
		logger.info("Enter 2 to Login as Respondent ");
		String str=sc.nextLine();
		while(!inputValidation.choiceValidation(str)) {
			System.out.println("Please enter Valid Choice");
			str=sc.next();
		}
			int choice=Integer.parseInt(str);
			switch(choice) {
			
			case 1:
				logger.info("Enter User name: ");
				String username1=sc.next();
				logger.info("Enter Password: ");
				String password1=sc.next();
				SurveyorDAO surveyorDao = Factory.getSurveyorDAOInstance();
				if(surveyorDao.validateSurveyor(username1,password1)) {
					SurveyorService.surveydetails();
				}else {
					logger.info("Login failed.\n");
					afterLogin();
				}
				flag=!flag;
				break;
			case 2:
				logger.info("Enter User name: ");
				String username2=sc.next();
				logger.info("Enter Password: ");
				String password2=sc.next();
				RespondentDAO respondentDao = Factory.getRespondentDAOInstance();
				if(respondentDao.validateRespondent(username2,password2)) {
					RespondentService respondentService = Factory.getRespondentServiceInstance();
					respondentService.respondentlist();
				}else {
					logger.info("Login failed.\n");
					afterLogin();
				}
				flag=!flag;
				break;
			case 3:
				logger.info("Thank you...");
				SurveyController.main(null);
				default:
					flag=!flag;
					logger.info(" Please select proper option.");
					break;
			}
		} while(flag=!flag);
		return false;
	}
}
