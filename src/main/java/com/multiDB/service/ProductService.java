package com.multiDB.service;

import java.util.List;
import java.util.Optional;

import com.multiDB.a.entity.Product;

public interface ProductService {
	List<Product> findAll();

	Optional<Product> findbyId(String id);
	
	void save(Product product);
	
	void update(Product product); 
	
	void delete(Product product); 
}
