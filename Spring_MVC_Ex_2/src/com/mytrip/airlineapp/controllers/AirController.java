package com.mytrip.airlineapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mytrip.airlineapp.models.Airline;

@Controller
public class AirController {
	@RequestMapping(value = "/addAirline.html")
	public String addAirline() {
		return "addAirline";
	}
	@RequestMapping(value = "/addAirline.html", method = RequestMethod.POST)
	public String addAirline(HttpServletRequest request, Model model) {
		String name = request.getParameter("airlineName");
		String serviceType = request.getParameter("serviceType");
		System.out.println(name +" type is "+serviceType);
		Airline airline = new Airline(name,serviceType);
		model.addAttribute("airlineObj",airline);
		return "result";
	}
}
