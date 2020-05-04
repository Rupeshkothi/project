package com.capgemini.surveyManagementSystem.validation;

public interface InputValidation {
	public boolean choiceValidation(String choice);
	public boolean nameValidation(String name);
	public boolean passwordValidation(String password);
	public boolean adminLoginId(String adminLoginId);
	public boolean surveyTitleValidation(String surveyTitle);
	public boolean surveyDescriptionValidation(String surveyDescription);
	public boolean emailValidation(String email);
	public boolean mobileNoValidation(String phoneNo);
	public boolean questionValidation(String question);
}
