package com.book.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.book.service.model.Author;
import com.book.service.model.Book;
import com.book.service.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}

	public Author getAuthorById(Long authorId) {
		return restTemplate.getForObject("http://localhost:8081/authors/" + authorId, Author.class);
	}
}