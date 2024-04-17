package com.multiDB.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.multiDB.a.entity.Product;
import com.multiDB.b.entity.Book;
import com.multiDB.service.BookService;
import com.multiDB.service.ProductService;
import com.multiDB.service.RollbackService;

@RestController
@RequestMapping("/jap/multiDB")
public class JpaController {
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
	
	@PostMapping("/findProduct")
	public Product findProduct(@RequestBody Product product) {
		return productService.findbyId(product.getId()).get();
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody Product product) {
		productService.save(product);
		return "save success";
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product) {
		productService.save(product);
		return "updateProduct success";
	}	
	
	
	@PostMapping("/deleteProduct")
	public String deleteProduct(@RequestBody Product product) {
		productService.delete(product);
		return "deleteProduct success";
	}		
	
	@PostMapping("/findAllBookList")
	public List<Book> findAllBookList() {
		return bookService.findAll();
	}
	
	@PostMapping("/findBook")
	public Book findBook(@RequestBody Book book) {
		return bookService.findbyId(book.getId()).get();
	}
	
	
	@PostMapping("/saveBook")
	public String saveBook(@RequestBody Book book) {
		bookService.save(book);
		return "save success";
	}
	
	@PostMapping("/updateBook")
	public String updateBook(@RequestBody Book book) {
		bookService.save(book);
		return "updatebook success";
	}	
	
	
	@PostMapping("/deleteBook")
	public String deleteBook(@RequestBody Book book) {
		bookService.delete(book);
		return "deletebook success";
	}		
	
	@PostMapping("/findBookByIdForNative")
	public List<Book> findBookByIdForNative(@RequestBody Book book) {
		return bookService.query(book.getId(),book.getPrice());
	}		
	
	@PostMapping("/rollback")
	public String rollback(@RequestBody Product product) {
		product.setId("etgwe");
		Book book = new Book();
		book.setId("asdfasdf");
		product.setName("修改後");
		book.setName("修改後");
		return rollbackService.save(product,book);
	}			
}
