package com.capgemini.surveyManagementSystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.capgemini.surveyManagementSystem.beans.Respondent;
import com.capgemini.surveyManagementSystem.dao.RespondentDAO;
import com.capgemini.surveyManagementSystem.factory.Factory;

class RespondentServiceTest {
	@Test
	@Tag("ValidateLogin")
	void testSurveyorService() {
		Respondent respondent = Factory.getRespondentInstance();
		RespondentDAO respondentDao = Factory.getRespondentDAOInstance();
		respondent.setUsername("respondent");
		respondent.setPassword("respondent");
		assertEquals(true, respondentDao.validateRespondent("respondent", "respondent"));
	}

	@Test
	void testRespondentList() {
		RespondentService respondentService = Factory.getRespondentServiceInstance();
		assertEquals(true, respondentService.respondentlist());
	}
}
