package com.capgemini.surveyManagementSystem.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.surveyManagementSystem.controller.SurveyController;
import com.capgemini.surveyManagementSystem.dao.RespondentDAO;
import com.capgemini.surveyManagementSystem.factory.Factory;
import com.capgemini.surveyManagementSystem.validation.InputValidation;

public class RespondentService {
	Scanner sc = new Scanner(System.in);
	static Logger log = Logger.getLogger(RespondentService.class);

	public boolean respondentService() {
		RespondentDAO respondentDao = Factory.getRespondentDAOInstance();
		respondentDao.validateRespondent("respondent", "respondent");
		return true;
	}

	public boolean respondentlist() {
		InputValidation inputValidation = Factory.getInputValidationInstance();
		log.info("Logged in successfully\n");
		do {
			log.info(" Enter the required options ");
			log.info(" 1. Respond for list ");
			log.info(" 2. View lists ");
			log.info(" 3. Exit");
			String choice = sc.next();
			while (!inputValidation.choiceValidation(choice)) {
				System.out.println("please enter valid choice");
				choice = sc.next();
			}
			int choice1 = Integer.parseInt(choice);
			switch (choice1) {
			case 1:
				RespondentDAO respondentDao1 = Factory.getRespondentDAOInstance();
				respondentDao1.respondList();
				break;
			case 2:
				RespondentDAO respondentDao2 = Factory.getRespondentDAOInstance();
				respondentDao2.viewrespondlist();
				break;
			case 3:
				log.info("Exit!!!");
				SurveyController.main(null);
			}
		} while (true);
	}

}
