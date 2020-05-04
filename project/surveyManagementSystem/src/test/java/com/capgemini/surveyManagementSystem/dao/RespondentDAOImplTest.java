package com.capgemini.surveyManagementSystem.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.capgemini.surveyManagementSystem.beans.Respondent;
import com.capgemini.surveyManagementSystem.factory.Factory;

class RespondentDAOImplTest {

	@Test
	@Tag("RespondList")
	void testRespondentList() {
		RespondentDAO respondentDAO = Factory.getRespondentDAOInstance();
		assertEquals(true, respondentDAO.respondList());
	}

	@Test
	@Tag("RespondList")
	void testRespondentList1() {
		RespondentDAO respondentDAO = Factory.getRespondentDAOInstance();
		assertEquals(false, respondentDAO.respondList());
	}

	@Test
	@Tag("Validate Login")
	void testRespondentLogin() {
		Respondent respondent = Factory.getRespondentInstance();
		RespondentDAO respondentDAO = Factory.getRespondentDAOInstance();
		respondent.setUsername("respondent");
		respondent.setPassword("respondent");
		assertEquals(true, respondentDAO.validateRespondent("respondent", "respondent"));
	}

	@Test
	@Tag("Validate Login")
	void testRespondentLogin1() {
		Respondent respondent = Factory.getRespondentInstance();
		RespondentDAO respondentDAO = Factory.getRespondentDAOInstance();
		respondent.setUsername("respondent");
		respondent.setPassword("respondent");
		assertEquals(false, respondentDAO.validateRespondent("respondent", "respondent"));
	}

}
