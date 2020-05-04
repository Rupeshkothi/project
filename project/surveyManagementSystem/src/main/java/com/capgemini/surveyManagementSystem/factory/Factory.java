package com.capgemini.surveyManagementSystem.factory;

import com.capgemini.surveyManagementSystem.beans.Admin;
import com.capgemini.surveyManagementSystem.beans.Respondent;
import com.capgemini.surveyManagementSystem.beans.Result;
import com.capgemini.surveyManagementSystem.beans.Survey;
import com.capgemini.surveyManagementSystem.beans.Surveyor;
import com.capgemini.surveyManagementSystem.dao.AdminDAO;
import com.capgemini.surveyManagementSystem.dao.AdminDAOImpl;
import com.capgemini.surveyManagementSystem.dao.RespondentDAO;
import com.capgemini.surveyManagementSystem.dao.RespondentDAOImpl;
import com.capgemini.surveyManagementSystem.dao.SurveyorDAO;
import com.capgemini.surveyManagementSystem.dao.SurveyorDAOImpl;
import com.capgemini.surveyManagementSystem.service.AdminService;
import com.capgemini.surveyManagementSystem.service.RespondentService;
import com.capgemini.surveyManagementSystem.service.SurveyorService;
import com.capgemini.surveyManagementSystem.validation.InputValidation;
import com.capgemini.surveyManagementSystem.validation.InputValidationImpl;

public class Factory {
	private Factory() {

	}
	public static SurveyorDAO getSurveyorDAOInstance() {
		SurveyorDAO surveyorDao = new SurveyorDAOImpl();
		return surveyorDao;

	}

	public static SurveyorService getSurveyorServiceInstance() {
		SurveyorService surveyorService = new SurveyorService();
		return surveyorService;
	}

	public static Admin getAdminInstance() {
		Admin admin = new Admin();
		return admin;

	}

	public static AdminDAO getAdminDAOInstance() {
		AdminDAO adminDao = new AdminDAOImpl();
		return adminDao;
	}

	public static AdminService getAdminServiceInstance() {
		AdminService adminService = new AdminService();
		return adminService;
	}
	public static InputValidation getInputValidationInstance() {
		return new InputValidationImpl();
	}
	public static Surveyor getSurveyorInstance() {
		// TODO Auto-generated method stub
		Surveyor surveyor=new Surveyor();
		return surveyor;
	}

	public static Survey getSurveyInstance() {
		// TODO Auto-generated method stub
		Survey survey=new Survey();
		return survey;
	}

	public static Respondent getRespondentInstance() {
		// TODO Auto-generated method stub
		Respondent respondent=new Respondent();
		return respondent;
	}

	public static RespondentService getRespondentServiceInstance() {
		// TODO Auto-generated method stub
		RespondentService respondentService=new RespondentService();
		return respondentService;
	}

	public static RespondentDAO getRespondentDAOInstance() {
		// TODO Auto-generated method stub
		RespondentDAO respondentDao=new RespondentDAOImpl();
		return respondentDao;
	}

	public static Result getResultInstance() {
		// TODO Auto-generated method stub
		Result result=new Result();
		return result;
	}

}
