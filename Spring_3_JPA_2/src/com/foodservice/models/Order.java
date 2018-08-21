package com.foodservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "OrderEntity")
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	private String foodItem;
	private float price;
	private boolean status;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float orderTotal) {
		this.price = orderTotal;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Order(long orderId, String foodItem, float orderTotal, boolean status) {
		super();
		this.orderId = orderId;
		this.foodItem = foodItem;
		this.price = orderTotal;
		this.status = status;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", foodItem=" + foodItem + ", price=" + price + ", status="
				+ status + "]";
	}
	
	
}
