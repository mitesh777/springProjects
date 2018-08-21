package com.shoppingkeeda.productportal.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@RequestMapping(value = "/")
	public String home() {
		System.out.println("here");
		return "home";
	}
	@RequestMapping(value = "/home.jsp")
	public ModelAndView homePage() {
		String viewName ="home";
		return new ModelAndView(viewName);
	}
	
	
	
}
