package com.mytrip.airlineapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mytrip.airlineapp.exceptions.ProductAlreadyExistException;
import com.shoppingkeeda.productportal.entities.Product;
import com.shoppingkeeda.productportal.services.ProductService;



@Controller
public class HomeController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/addProduct.html")
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("productObj",product);
		return "addProduct";
	}
	@RequestMapping(value = "/addProduct.html", method = RequestMethod.POST)
	public String addProduct(Model model,@ModelAttribute("productObj") Product product) {
//		String name = model.getAttribute("airlineName");
//		String serviceType = model.getParameter("serviceType");
		//System.out.println(name +" type is "+serviceType);
		//airline = new Airline(name,serviceType);
		
		try {
			long id=service.saveProduct(product);
			model.addAttribute("message","added");
		} catch (ProductAlreadyExistException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
		}
		
		
		return "result";
	}
	
	
}
