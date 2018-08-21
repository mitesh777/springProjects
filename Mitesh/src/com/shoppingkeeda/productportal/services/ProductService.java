package com.shoppingkeeda.productportal.services;

import java.util.List;

import com.mytrip.airlineapp.exceptions.ProductAlreadyExistException;
import com.shoppingkeeda.productportal.entities.Product;

public interface ProductService {
	public long saveProduct(Product product) throws ProductAlreadyExistException;
	
	public List<Product> listAllProducts();
	Product searchProductByName(String s);
}
