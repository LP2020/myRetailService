package com.myretail.products.controller;


import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.products.model.Product;
import com.myretail.products.service.ProductService;

@RestController
@RequestMapping(value= "/myretail")
public class ProductController {
	
	private final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService serv;

	
	
	@PostMapping(value= "/product")
	public String registerProduct(@RequestBody Product productObj) {
		logger.debug("Saving Products.");
		serv.createProduct(productObj);
		return "Product records created.";
	}

	@PutMapping(value= "/product/{product-id}")
	public String editProduct(@PathVariable("product-id") int id,@RequestBody Product productObj) {
		logger.debug("Update Products.");
		serv.updateProduct(id,productObj);
		return "Product record updated.";
	}
		
	/**
	 * Method to get all Products from the database.
	 * @return
	 */
	@GetMapping(value= "/products")
	public Collection<Product> getAll() {
		//logger.debug("Getting all Products.");
			return serv.getAllProducts();
	}

	/**
	 * Method to fetch a product by id.
	 * @param id
	 * @return
	 */
	@GetMapping(value= "/product/{product-id}")
	public Optional<Product> getProductById(@PathVariable(value= "product-id") int id) {
		//logger.debug("Getting Product with product-id= {}.", id);
				return serv.findProductById(id);
	}

}