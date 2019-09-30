package com.myretail.products.service;


import java.util.Collection;
import java.util.Optional;

import com.myretail.products.model.Product;

public interface ProductService {

	public void createProduct(Product productObj);
	
	public void updateProduct(int id, Product productObj);

	public Collection<Product> getAllProducts();

	public Optional<Product> findProductById(int id);


}