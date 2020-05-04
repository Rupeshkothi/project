package com.capgemini.surveyManagementSystem.dao;

import java.util.List;

import com.capgemini.surveyManagementSystem.beans.Survey;
import com.capgemini.surveyManagementSystem.beans.Surveyor;

public interface SurveyorDAO {
	boolean validateSurveyor(String username, String password);

	public void addQuestions();

	public boolean createSurvey(Surveyor surveyor);

	public boolean editSurvey(Surveyor surveyor);

	public boolean deleteSurvey(String surveyTitle);

	public void distributeSurvey();

	public List<Survey> getAllSurveys();
}
