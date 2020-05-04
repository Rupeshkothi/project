package com.capgemini.surveyManagementSystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.capgemini.surveyManagementSystem.beans.Surveyor;
import com.capgemini.surveyManagementSystem.dao.SurveyorDAO;
import com.capgemini.surveyManagementSystem.factory.Factory;

class SurveyorServiceTest {

	@Test
	@Tag("ValidateLogin")
	void testSurveyorService() {
		Surveyor surveyor = Factory.getSurveyorInstance();
		SurveyorDAO surveyorDao = Factory.getSurveyorDAOInstance();
		surveyor.setUsername("surveyor");
		surveyor.setPassword("surveyor");
		assertEquals(true, surveyorDao.validateSurveyor("surveyor", "surveyor"));
	}

	@Test
	@Tag("Survey details")
	void testSurveyDetails() {
		assertEquals(true, SurveyorService.surveydetails());
	}
}
