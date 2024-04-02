package com.multiDB.service.impl;

import java.math.BigDecimal;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multiDB.b.dao.BookDao;
import com.multiDB.b.entity.Book;
import com.multiDB.service.BookService;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public Optional<Book> findbyId(String id) {
		return bookDao.findById(id);
	
	}

	@Override
	public void save(Book book) {
		bookDao.save(book);
	}

	@Override
	public void update(Book book) {
		bookDao.save(book);
	}

	@Override
	public void delete(Book book) {
		bookDao.delete(book);
	}

	@Override
	public List<Book> query(String id,BigDecimal price) {
		return bookDao.query(id, price);
	}

	@Override
	@Transactional("bTransactionManager")
	public void errorSave(Book book) {
		bookDao.save(book);
		if(1 == 1/0) {
			
		}
	}
}
