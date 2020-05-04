package com.capgemini.surveyManagementSystem.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.surveyManagementSystem.factory.Factory;

class InputValidationImplTest {
	InputValidation inputValidation = Factory.getInputValidationInstance();

	@Test
	void testNameValidation() {
		assertEquals(true, inputValidation.nameValidation("Amazon"));
	}

	@Test
	void testNameValidation1() {
		assertEquals(false, inputValidation.nameValidation("Amazon"));
	}

	@Test
	void testChoiceValidate() {
		assertEquals(true, inputValidation.choiceValidation("4"));
	}

	@Test
	void testChoiceValidate1() {
		assertEquals(false, inputValidation.choiceValidation("4"));
	}

	@Test
	void testEmailValidation() {
		assertEquals(true, inputValidation.emailValidation("rupesh@gmail.com"));
	}

	@Test
	void testEmailValidation1() {
		assertEquals(false, inputValidation.emailValidation("rupesh@gmail.com"));
	}

	@Test
	void testPasswordValidation() {
		assertEquals(true, inputValidation.passwordValidation("rupesh@1123"));
	}

	@Test
	void testPasswordValidation1() {
		assertEquals(false, inputValidation.passwordValidation("rupesh@1123"));
	}

	@Test
	void testMobileNoValidation() {
		assertEquals(true, inputValidation.mobileNoValidation("8978408595"));
	}

	@Test
	void testMobileNoValidation1() {
		assertEquals(false, inputValidation.mobileNoValidation("8978408595"));
	}

	@Test
	void testSurveyValidation() {
		assertEquals(true, inputValidation.surveyTitleValidation("survey"));
	}

	@Test
	void testSurveyValidation1() {
		assertEquals(false, inputValidation.surveyTitleValidation("survey"));
	}

	@Test
	void testDescriptionValidation() {
		assertEquals(true, inputValidation.surveyDescriptionValidation("survey"));
	}

	@Test
	void testDescriptionValidation1() {
		assertEquals(false, inputValidation.surveyDescriptionValidation("survey"));
	}

}
