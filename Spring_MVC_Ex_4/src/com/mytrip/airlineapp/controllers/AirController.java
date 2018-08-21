package com.mytrip.airlineapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mytrip.airlineapp.exceptions.AirlineNotFoundException;
import com.mytrip.airlineapp.exceptions.DuplicateAirlineException;
import com.mytrip.airlineapp.models.Airline;
import com.mytrip.airlineapp.services.AirlineService;

@Controller
public class AirController {
	
	@Autowired
	private AirlineService service;
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
		String viewName = "result";
		long id=0;
		try {
			id = service.addAirline(airline);
			airline.setId(id);
			model.addAttribute("airlineObj",airline);
			viewName = "showAirline";
		} catch (DuplicateAirlineException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message",e.getMessage());
		}
		
		return viewName;
	}
	
	@RequestMapping(value = "/searchAirline.html")
	public String searchAirline() {
//		String name = model.getAttribute("airlineName");
//		String serviceType = model.getParameter("serviceType");
		//System.out.println(name +" type is "+serviceType);
		//airline = new Airline(name,serviceType);
		
		return "searchAirline";
	}
	
	@RequestMapping(value = "/searchAirline.html", method = RequestMethod.POST)
	public String searchAirline(@RequestParam("airlineId") long id,Model model) {
		System.out.println("airline id to be searched "+ id);
		Airline airline = null;
		String viewName = "";
		try {
			airline = service.getAirlineById(id);
			model.addAttribute("airlineObj", airline);
			viewName = "showAirline";
		} catch (AirlineNotFoundException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", "couldn't find name "+id);
			viewName = "result";
		}
		//model.addAttribute("airlineObj",airline);
		return viewName;
	}
	
	@RequestMapping(value = "/searchAirlineByName.html", method = RequestMethod.POST)
	public String searchAirlineByName(@RequestParam("airlineName") String name,Model model) {
		System.out.println("airline id to be searched"+ name);
		Airline airline = null;
		String viewName = "";
		try {
			airline = service.getAirlineByName(name);
			model.addAttribute("airlineObj", airline);
			viewName = "showAirline";
		} catch (AirlineNotFoundException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", "couldn't find name "+name);
			viewName = "result";
		}
		//model.addAttribute("airlineObj",airline);
		return viewName;
	}
	
	@RequestMapping(value = "/searchAirlineByName.html")
	public String searchAirlineByName() {
//		String name = model.getAttribute("airlineName");
//		String serviceType = model.getParameter("serviceType");
		//System.out.println(name +" type is "+serviceType);
		//airline = new Airline(name,serviceType);
		
		return "searchAirlineByName";
	}
	
	@RequestMapping(value = "/updateAirline.html")
	public String updateAirline(Model model) {
		Airline airline = new Airline();
		model.addAttribute("airlineObj",airline);
		return "updateAirline";
	}
	@RequestMapping(value = "/updateAirline.html", method = RequestMethod.POST)
	public String updateAirline(Model model,@ModelAttribute("airlineObj") Airline airline) {
//		String name = model.getAttribute("airlineName");
//		String serviceType = model.getParameter("serviceType");
		//System.out.println(name +" type is "+serviceType);
		//airline = new Airline(name,serviceType);
		boolean updated = service.updateAirline(airline);
		//airline.setId(id);
		if(updated) {
			model.addAttribute("airlineObj",airline);
			return "showAirline";
		}
		else {
			model.addAttribute("message", "couldn't find id = "+ airline.getId());
			return "result";
		}
		
	}
}
