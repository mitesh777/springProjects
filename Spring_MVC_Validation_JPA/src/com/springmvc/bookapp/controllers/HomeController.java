package com.springmvc.bookapp.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.bookapp.entities.Book;
import com.springmvc.bookapp.services.BookService;
import com.springmvc.bookapp.validators.BookValidator;

@Controller
public class HomeController {
	
	@Autowired
	BookService service;
	
	@Autowired
	BookValidator validator;
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	@RequestMapping(value = "/home.html")
	public ModelAndView homePage() {
		String viewName ="home";
		return new ModelAndView(viewName);
	}
	
	@RequestMapping(value = "/addBook.html")
	public ModelAndView addBook() {
		String viewName = "addBook";
		String modelName = "bookObj";
		Book book =new Book();
		
		return new ModelAndView(viewName, modelName, book);
	}
	
	@RequestMapping(value = "/addBook.html", method = RequestMethod.POST)
	public ModelAndView addBook(@ModelAttribute("bookObj") Book book, BindingResult br) {
		
		String viewName = "showBook";
		
		validator.validate(book, br);
		HashMap<String, Object> map = null;
		if(br.hasErrors()) {
			viewName = "addBook";
			System.out.println("sup");
		}
		else {
			long id = service.addBook(book);
			System.out.println(id);
			map = new HashMap<String, Object>();
			map.put("book", book);
			map.put("currentDate", new Date());
			System.out.println(book);
		}
		
		
		//if we have more than 1 model to the next view, we have to make a map of<String, Object> and pass
		//this to the model
		
		return new ModelAndView(viewName, map);
	}
	
	@ModelAttribute("authors")
	public List<String> getAuthors(){
		List<String> list = new ArrayList<String>();
		list.add("avc");
		list.add("avc2");
		list.add("avc3");
		list.add("avc4");
		list.add("avc5");
		return list;
	}
	
	
}
