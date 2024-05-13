package com.multiDB.service;

import com.multiDB.a.entity.Product;
import com.multiDB.b.entity.Book;

public interface RollbackService {

	String save(Product product,Book book) ;
}
