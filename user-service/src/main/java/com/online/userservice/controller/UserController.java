package com.online.userservice.controller;

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

import com.online.userservice.model.User;
import com.online.userservice.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
    private UserRepository userRepository;

    @PostMapping
    public User saveUser(@Valid @RequestBody User user) {
    	logger.info("saveUser");
    	return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
    	logger.info("getAllUsers");
    	return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
    	logger.info("getUserById");
    	return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public User updateUser(@Valid @RequestBody User user) {
    	logger.info("updateUser");
    	return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
    	logger.info("deleteUser - id is {}", id);
    	userRepository.deleteById(id);
    }
}
