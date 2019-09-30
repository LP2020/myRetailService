package com.myretail.products.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myretail.products.model.Product;

@Repository
public interface Productdao extends MongoRepository<Product, Integer> {

}