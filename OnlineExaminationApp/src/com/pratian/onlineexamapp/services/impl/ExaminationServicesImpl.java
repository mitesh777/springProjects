package com.pratian.onlineexamapp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.onlineexamapp.dao.ExaminationDAO;
import com.pratian.onlineexamapp.exceptions.NameAlreadyExistsException;
import com.pratian.onlineexamapp.models.Question;
import com.pratian.onlineexamapp.models.Result;
import com.pratian.onlineexamapp.services.ExaminationService;

@Service
public class ExaminationServicesImpl implements ExaminationService {

	@Autowired
	ExaminationDAO dao;
	
	@Override
	public boolean checkName(String name) throws NameAlreadyExistsException {
		if(dao.checkNameInDB(name)) {
			throw new NameAlreadyExistsException("Name already exists. Add another Name");
		}
		return false;
	}

	@Override
	public long addResult(Result result) throws NameAlreadyExistsException {
		// TODO Auto-generated method stub
		if(checkName(result.getUserName())) {
			throw new NameAlreadyExistsException();
		}
		else {
			return dao.saveResult(result);
		}
	}

	@Override
	public List<Question> getQuestions(String subjectName) {
		// TODO Auto-generated method stub
		
		return dao.fetchQuestions(subjectName);
	}

	@Override
	public List<String> getSubjects() {
		// TODO Auto-generated method stub
		return dao.fetchSubjects();
	}

	@Override
	public Question getQuestion(String subjectName, int id) {
		// TODO Auto-generated method stub
		return dao.fetchQuestion(subjectName, id);
		//null;
	}

	@Override
	public int getResult(List<Integer> answers, String subject) {
		// TODO Auto-generated method stub
		return dao.fetchResult(answers, subject);
	}

	@Override
	public int getTotalQuestions(String subject) {
		// TODO Auto-generated method stub
		return dao.fetchTotalQuestions(subject);
	}

}
