package com.mytrip.airlineapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mytrip.airlineapp.models.Airline;

@Controller
public class AirController {
	@RequestMapping(value = "/addAirline.html")
	public String addAirline(Model model) {
		Airline airline = new Airline();
		model.addAttribute("airlineObj",airline);
		return "addAirline";
	}
	@RequestMapping(value = "/addAirline.html", method = RequestMethod.POST)
	public String addAirline(Model model,@ModelAttribute("airlineObj") Airline airline) {
//		String name = model.getAttribute("airlineName");
//		String serviceType = model.getParameter("serviceType");
		//System.out.println(name +" type is "+serviceType);
		//airline = new Airline(name,serviceType);
		model.addAttribute("airlineObj",airline);
		return "result";
	}
}
