package com.pratian.onlineexamapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pratian.onlineexamapp.exceptions.NameAlreadyExistsException;
import com.pratian.onlineexamapp.models.Result;
import com.pratian.onlineexamapp.services.ExaminationService;

@Controller
public class HomeController {
	
	@Autowired
	ExaminationService service;
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/home")
	public String home123() {
		return "home";
	}
	
	@RequestMapping(value = "/home.html", method = RequestMethod.POST)
	public String home123(@RequestParam("name") String name,Model model, HttpServletRequest request) {
		String view="home";
		try {
			if(!service.checkName(name)) {
				view = "selectSubject";
				List<String> subjects = service.getSubjects();
				model.addAttribute("subjects", subjects);
				//service.addResult(new Result(1L, name, "game", 0, new ArrayList<Integer>()));
				request.getSession().setAttribute("studentName",name);
				System.out.println("home calls name = "+name);
				//model.addAttribute("", arg1);
			}
		} catch (NameAlreadyExistsException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",name + " has given the test ");
			view = "home";
			
		}
		
		return view;
	}
}
