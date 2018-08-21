package com.foodservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodservice.dao.OrderDao;
import com.foodservice.models.Order;

public interface OrderService {
	
	Order getOrderById(long id);
	
	long saveOrder(Order order);
	
	List<Order> getOrders();
}
