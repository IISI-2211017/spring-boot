package com.multiDB.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.multiDB.b.entity.Book;

public interface BookService {
	List<Book> findAll();

	Optional<Book> findbyId(String id);
	
	void save(Book book);
	
	void update(Book book); 
	
	void delete(Book book); 
	
	List<Book> query(String id,BigDecimal price);
	
	void errorSave(Book book); 
}
