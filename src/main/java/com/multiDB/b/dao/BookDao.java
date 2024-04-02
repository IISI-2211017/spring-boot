package com.multiDB.b.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.multiDB.b.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, String>{
//	@Query(name = "findBook",nativeQuery = false)
//	List<Book> query(@Param("id") String id,@Param("price") BigDecimal price);
	
	//只能使用entity的名稱
	@Query("SELECT b FROM Book b WHERE b.id = :id AND b.price >= :price")
	List<Book> query(@Param("id") String id,@Param("price") BigDecimal price);
}
