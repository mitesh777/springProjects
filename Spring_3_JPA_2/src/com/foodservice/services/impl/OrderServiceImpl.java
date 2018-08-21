package com.foodservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.dao.OrderDao;
import com.foodservice.models.Order;
import com.foodservice.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	@Override
	public Order getOrderById(long id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public long saveOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
