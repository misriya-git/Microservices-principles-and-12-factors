package com.book.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.service.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}