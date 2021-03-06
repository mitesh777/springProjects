package com.pratian.onlineexamapp.services;

import java.util.List;

import com.pratian.onlineexamapp.exceptions.NameAlreadyExistsException;
import com.pratian.onlineexamapp.models.Question;
import com.pratian.onlineexamapp.models.Result;

public interface ExaminationService {
	
	boolean checkName(String name) throws NameAlreadyExistsException;
	
	long addResult(Result result) throws NameAlreadyExistsException;
	
	Question getQuestion(String subjectName, int id);
	
	int getResult(List<Integer> answers, String subject);
	
	List<Question> getQuestions(String subjectName);
	
	List<String> getSubjects();
	
	int getTotalQuestions(String subject);
	
}
