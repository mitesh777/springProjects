package com.foodservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodservice.controller.dto.FoodPrice;
import com.foodservice.models.Order;
import com.foodservice.services.OrderService;
@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/newOrder.html")
	public ModelAndView addOrder() {
		System.out.println("here");
		String viewName = "newOrder";
		String modelName = "command";//???
		Order order = new Order();
		ModelAndView modelAndView = new ModelAndView(viewName, modelName, order);
		return modelAndView;
	}
	
	@RequestMapping(value = "/newOrder.html", method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute("command") Order order) {
		//System.out.println("hellp "+order);
		for(FoodPrice fp:getFoodMenus()) {
			if(fp.getFoodName().equals(order.getFoodItem())) {
				order.setPrice(fp.getPrice());
				break;
			}
		}
		System.out.println(order);
		return "orderConfirm";
	}
	
	@ModelAttribute("foodMenus")
	public List<FoodPrice> getFoodMenus(){
		List<FoodPrice> menus = new ArrayList<FoodPrice>();
		menus.add(new FoodPrice("North food",150.0f));
		menus.add(new FoodPrice("South food",150.0f));
		menus.add(new FoodPrice("Combo",170.0f));
		return menus;
	}
	public String save() {
		return "saveOrder";
	}
	
}
