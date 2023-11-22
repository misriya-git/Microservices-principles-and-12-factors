package com.book.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.model.Author;
import com.book.service.model.Book;
import com.book.service.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
    private BookService bookService;

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
    	logger.info("saveBook");
    	return bookService.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
    	logger.info("getAllBooks");
    	return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
    	logger.info("getBookById");
    	return bookService.findById(id);
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable("id") Long id) {
    	logger.info("id is {}", id);
    	return bookService.getAuthorById(id);
    }    

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book) {
    	logger.info("updateBook");
    	return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
    	logger.info("deleteBook - id is {}", id);
    	bookService.deleteById(id);
    }
}
