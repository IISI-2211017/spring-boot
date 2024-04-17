package com.multiDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiDB.a.entity.Product;
import com.multiDB.service.BookService;
import com.multiDB.service.ProductService;
import com.multiDB.service.RollbackService;
@RestController
@RequestMapping("/jap/multiDB2")
public class SwaggerController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RollbackService rollbackService;
	
	@PostMapping("/findAllProList")
	public List<Product> findAllProList() {
		return productService.findAll();
	}
}
