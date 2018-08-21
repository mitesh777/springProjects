package com.foodservice.controller.dto;

public class FoodPrice {
	private String foodName;
	private float price;
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public FoodPrice(String foodName, float price) {
		super();
		this.foodName = foodName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "FoodPrice [foodName=" + foodName + ", price=" + price + "]";
	}
	
	
}
