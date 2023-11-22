package com.order.service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.service.model.Book;

@FeignClient(name = "book-service", url = "http://localhost:8083")
public interface BookClient {
	@GetMapping("/books/{id}")
    Book getBookById(@PathVariable Long id);
}
