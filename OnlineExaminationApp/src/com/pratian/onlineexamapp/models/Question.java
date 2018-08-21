package com.pratian.onlineexamapp.models;

import java.util.Arrays;

public class Question {
	private long questionId;
	private String questionString;
	private String[] options = new String[4];
	private int correctOption;
	
	public Question(long questionId, String questionString, String[] options, int correctOption) {
		super();
		this.questionId = questionId;
		this.questionString = questionString;
		this.options = options;
		this.correctOption = correctOption;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionString() {
		return questionString;
	}
	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public int getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(int correctOption) {
		this.correctOption = correctOption;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionString=" + questionString + ", options="
				+ Arrays.toString(options) + ", correctOption=" + correctOption + "]";
	}
	
	
}
