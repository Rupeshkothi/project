package com.capgemini.surveyManagementSystem.dao;

import java.util.List;

import com.capgemini.surveyManagementSystem.beans.Result;

public interface RespondentDAO {
	boolean validateRespondent(String username, String password);

	public boolean respondList();

	public List<Result> viewrespondlist();

}
