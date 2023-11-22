package com.online.reviewservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.online.reviewservice.exception.ReviewNotFoundException;
import com.online.reviewservice.model.Book;
import com.online.reviewservice.model.Review;
import com.online.reviewservice.repository.ReviewRepository;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Book getBook(Long bookId) {
        return restTemplate.getForObject("http://localhost:8083/books/" + bookId, Book.class);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
    	Book book = getBook(review.getBookId());
        if (book != null) {
            return reviewRepository.save(review);
        } else {
            throw new ReviewNotFoundException("Book Not Found!");
        }
    }
}