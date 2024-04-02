package com.multiDB.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multiDB.a.dao.ProductDao;
import com.multiDB.a.entity.Product;
import com.multiDB.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Optional<Product> findbyId(String id) {
		return productDao.findById(id);
	}

	@Override
	@Transactional("aTransactionManager")
	public void save(Product product) {
		productDao.save(product);
	}

	@Override
	public void update(Product product) {
		productDao.save(product);
	}

	@Override
	public void delete(Product product) {
		productDao.delete(product);		
	}

}
