package com.pratian.onlineexamapp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pratian.onlineexamapp.dao.ExaminationDAO;
import com.pratian.onlineexamapp.models.Question;
import com.pratian.onlineexamapp.models.Result;

@Repository
public class ExaminationDAOImplements implements ExaminationDAO {
	
	private HashMap<String,List<Question>> questionBank;
	private List<String> subjects;
	private List<Result> results;
	
	
	
	public ExaminationDAOImplements() {
		super();
		this.questionBank = new HashMap<String,List<Question>>();
		this.subjects = new ArrayList<String>();
		results = new ArrayList<Result>();
		
		subjects.add("Java Core");
		subjects.add("Servlets");
		String[] options = {"abc","now","save","me"};
		String[] options2 = {"def","how","to","next"};
		Question question1= new Question(1L, "What is java?", options, 3);
		Question question2 = new Question(2L, "Why is java?", options2, 1);
		List<Question> questions =   new ArrayList<Question>();
		questions.add(question1);questions.add(question2);
		questionBank.put("Java Core", questions);
		
		
		
		Question question3= new Question(3L, "What is Servlet?", options, 0);
		Question question4 = new Question(4L, "Why is servlet?", options2, 2);
		Question question5 = new Question(5L, "How is servlet?", options, 3);
		List<Question> questions2 =   new ArrayList<Question>();
		questions2.add(question3);questions2.add(question4);questions2.add(question5);
		questionBank.put("Servlets", questions2);
	}

	

	@Override
	public boolean checkNameInDB(String name) {
		
		for(Result result: results) {
			if(result.getUserName().equals(name)) {
				return true;
			}
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long saveResult(Result result) {
		// TODO Auto-generated method stub
		int size = results.size()+1;
		result.setResultId(size);
		results.add(result);
		return size;
	}

	@Override
	public List<Question> fetchQuestions(String subjectName) {
		// TODO Auto-generated method stub
		return questionBank.get(subjectName);
	}

	@Override
	public List<String> fetchSubjects() {
		// TODO Auto-generated method stub
		return subjects;
	}



	@Override
	public Question fetchQuestion(String subjectName, int id) {
		// TODO Auto-generated method stub
		return questionBank.get(subjectName).get(id);
		
	}



	@Override
	public int fetchResult(List<Integer> answers, String subject) {
		// TODO Auto-generated method stub
	List<Question> questions = questionBank.get(subject);
	int correct=0;
	int i=0;
	for(Question question : questions) {
		if(question.getCorrectOption()==answers.get(i)) {
			++correct;
		}
		++i;
	}
		return correct;
	}
	

//	public static void main(String[] args) {
//		ExaminationDAOImplements dao = new ExaminationDAOImplements();
//		List<Integer> al = new ArrayList<Integer>();
//		al.add(0);al.add(1);
//		System.out.println(dao.fetchResult(al, "Java Core"));
//	}


	@Override
	public int fetchTotalQuestions(String subject) {
		// TODO Auto-generated method stub
		
		return questionBank.get(subject).size();
	}

}
