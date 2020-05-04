package com.capgemini.surveyManagementSystem.beans;

import java.util.Arrays;

public class Result {

	private String answer1[], answer2[], answer3[], answer4[], answer5[];

	public String[] getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String[] answer1) {
		this.answer1 = answer1;
	}

	public String[] getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String[] answer2) {
		this.answer2 = answer2;
	}

	public String[] getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String[] answer3) {
		this.answer3 = answer3;
	}

	public String[] getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String[] answer4) {
		this.answer4 = answer4;
	}

	public String[] getAnswer5() {
		return answer5;
	}

	public void setAnswer5(String[] answer5) {
		this.answer5 = answer5;
	}
	@Override
	public String toString() {
		return "Resultbean [answer1=" + Arrays.toString(answer1) + ", answer2=" + Arrays.toString(answer2)
				+ ", answer3=" + Arrays.toString(answer3) + ", answer4=" + Arrays.toString(answer4) + ", answer5=" + Arrays.toString(answer5) +"]";
	}
}
