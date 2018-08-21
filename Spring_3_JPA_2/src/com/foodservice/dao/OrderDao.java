package com.foodservice.dao;

import java.util.List;

import com.foodservice.models.Order;

public interface OrderDao {
	long persistOrder(Order order);
	
	Order findByOrderId(long orderId);
	
	List<Order> listOrders();
	
	Order findByFoodItem(String foodItem);
}
