package com.capgemini.surveyManagementSystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.capgemini.surveyManagementSystem.beans.Surveyor;
import com.capgemini.surveyManagementSystem.factory.Factory;

class SurveyorDAOImplTest {
	@Test
	@Tag("Validate Login")
	void testSurveyorLogin() {
		Surveyor surveyor = Factory.getSurveyorInstance();
		SurveyorDAO surveyorDAO = Factory.getSurveyorDAOInstance();
		surveyor.setUsername("surveyor");
		surveyor.setPassword("surveyor");
		assertEquals(true, surveyorDAO.validateSurveyor("surveyor", "surveyor"));
	}

	@Test
	@Tag("Validate Login")
	void testSurveyorLogin1() {
		Surveyor surveyor = Factory.getSurveyorInstance();
		SurveyorDAO surveyorDAO = Factory.getSurveyorDAOInstance();
		surveyor.setUsername("surveyor");
		surveyor.setPassword("surveyor");
		assertEquals(false, surveyorDAO.validateSurveyor("surveyor", "surveyor"));
	}

	@Test
	@Tag("add")
	@BeforeEach
	@DisplayName("Create Survey1")
	void testCreateSurvey1() {
		SurveyorDAO surveyorDAO = Factory.getSurveyorDAOInstance();
		Surveyor survey = Factory.getSurveyorInstance();
		assertEquals(true, surveyorDAO.createSurvey(survey));
	}

	@Test
	@Tag("add")
	@BeforeEach
	@DisplayName("Create Survey2")
	void testCreateSurvey2() {
		SurveyorDAO surveyorDAO = Factory.getSurveyorDAOInstance();
		Surveyor survey = Factory.getSurveyorInstance();
		assertEquals(false, surveyorDAO.createSurvey(survey));
	}

	@Test
	@Tag("Edit-1")
	void testEditSurvey1() {
		SurveyorDAO surveyorDAO = Factory.getSurveyorDAOInstance();
		Surveyor surveyor = Factory.getSurveyorInstance();
		assertEquals(true, surveyorDAO.editSurvey(surveyor));
	}

	@Test
	@Tag("Edit-2")
	void testEditSurvey2() {
		SurveyorDAO surveyorDAO = Factory.getSurveyorDAOInstance();
		Surveyor surveyor = Factory.getSurveyorInstance();
		assertEquals(false, surveyorDAO.editSurvey(surveyor));
	}

	@Test
	@Tag("Delete-1")
	void testDeleteSurvey1() {
		SurveyorDAO surveyorDAO = Factory.getSurveyorDAOInstance();
		assertEquals(true, surveyorDAO.deleteSurvey(null));
	}

	@Test
	@Tag("Delete-2")
	void testDeleteSurvey2() {
		SurveyorDAO surveyorDAO = Factory.getSurveyorDAOInstance();
		assertEquals(false, surveyorDAO.deleteSurvey(null));
	}

	@Test
	@Tag("getall")
	void testGetAllSurveys1() {
		SurveyorDAO surveyorDAO = Factory.getSurveyorDAOInstance();
		assertNotNull(surveyorDAO.getAllSurveys());
	}

}
