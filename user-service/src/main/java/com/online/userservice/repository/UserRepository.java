package com.online.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}