package com.myretail.products.service;


import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.products.controller.ProductController;
import com.myretail.products.dao.Productdao;
import com.myretail.products.model.Product;

@Service
public class Producteserviceimpl implements ProductService {

	private final Logger logger = LoggerFactory.getLogger(Producteserviceimpl.class);

	@Autowired
	Productdao dao;


	@Override
	public void createProduct(Product productObj) {
		dao.save(productObj);
	}
	
	@Override
	public void updateProduct(int id, Product productObj) {
		Optional <Product> prd=findProductById(id);
		
		if (prd.isPresent() ) {
		Product pr=prd.get(); 
			pr.setProductid(id);
			pr.setProductprice(productObj.getProductprice());
			dao.save(pr);
		}
		
	}


	@Override
	public Collection<Product> getAllProducts() {
		
		return dao.findAll();
	}


	@Override
	public Optional<Product> findProductById(int id) {
		
		return dao.findById(id);
	}


}