package com.shoppingkeeda.productportal.entities;

import java.util.Date;

import org.springframework.stereotype.Component;

public class Product {
	private long productId;
	private String productName;
	private float price;
	private Date manufacturingDate;
	private String category;

	public Product(String productName, float price, Date manufacturingDate, String category) {
		super();
		this.productName = productName;
		this.price = price;
		this.manufacturingDate = manufacturingDate;
		this.category = category;
	}

	public Product(long productId, String productName, float price, Date manufacturingDate, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.manufacturingDate = manufacturingDate;
		this.category = category;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
