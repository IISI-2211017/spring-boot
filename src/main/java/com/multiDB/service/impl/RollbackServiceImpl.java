package com.multiDB.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiDB.a.entity.Product;
import com.multiDB.b.dao.BookDao;
import com.multiDB.b.entity.Book;
import com.multiDB.service.BookService;
import com.multiDB.service.ProductService;
import com.multiDB.service.RollbackService;
@Service
public class RollbackServiceImpl implements RollbackService{
	@Autowired
	BookService bookService;
	
	@Autowired
	ProductService productService;

	@Override
	public String save(Product product, Book book) {
		String a = "";
		String b = "";
		try {
			productService.save(product);
			bookService.errorSave(book);
		} catch (Exception e) {
			
		}
		finally {
			a = productService.findbyId(product.getId()).get().getName();
			b = bookService.findbyId(book.getId()).get().getName();
		}
		return "product name:"+ a + ",book name:" + b;
	}	
	
	
}
