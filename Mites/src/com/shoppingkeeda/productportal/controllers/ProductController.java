package com.shoppingkeeda.productportal.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class ProductController {
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	
}
