package com.capgemini.surveyManagementSystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidationImpl implements InputValidation {
	Pattern pt = null;
	Matcher mt = null;

	public boolean choiceValidation(String choice) {
		pt = Pattern.compile("[1-4&&[^a-zA-Z]]{1}");
		mt = pt.matcher(choice);
		if (mt.matches()) {
			return true;
		}
		return false;
	}

	public boolean nameValidation(String name) {
		pt = Pattern.compile("[a-z]");
		mt = pt.matcher(name);
		if (mt.matches()) {
			return true;
		}
		return false;
	}

	public boolean passwordValidation(String password) {
		// TODO Auto-generated method stub
		pt=Pattern.compile("[a-zA-Z0-9@!#$%^&*]+");
		mt=pt.matcher(password);
		if (mt.matches()) {
			return true;
		}
		return false;
	}
	public boolean questionValidation(String question) {
		pt=Pattern.compile("^[a-zA-Z\\h]+[.?!]$");
		mt=pt.matcher(question);
		if(mt.matches()) {
			return true;
		}
		return false;
	}

	public boolean adminLoginId(String adminLoginId) {
		// TODO Auto-generated method stub
		pt = Pattern.compile("(\\\\p{Lower}+\\\\s?)");
		mt = pt.matcher(adminLoginId);
		return false;
	}

	public boolean surveyTitleValidation(String surveyTitle) {
		// TODO Auto-generated method stub
		pt = Pattern.compile("^[a-zA-Z0-9]*$");
		mt = pt.matcher(surveyTitle);
		if (mt.matches()) {
			return true;
		}
		return false;
	}

	public boolean surveyDescriptionValidation(String surveyDescription) {
		// TODO Auto-generated method stub
		pt = Pattern.compile("^[a-zA-Z0-9?]*$");
		mt = pt.matcher(surveyDescription);
		if (mt.matches()) {
			return true;
		}
		return false;
	}

	public boolean emailValidation(String email) {
		// TODO Auto-generated method stub
		pt=Pattern.compile("^(.+)@(.+)$");
		mt=pt.matcher(email);
		if(mt.matches()) {
			return true;
		}
		return false;
	}

	public boolean mobileNoValidation(String phoneNo) {
		// TODO Auto-generated method stub
		pt=Pattern.compile("[6-9][0-9]{9}");
		mt=pt.matcher(phoneNo);
		if(mt.matches()) {
			return true;
		}
		return false;
	}

}
