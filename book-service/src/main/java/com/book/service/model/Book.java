package com.book.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book
{  

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String title;
private String ISBN;
private Long authorId;
@Enumerated(EnumType.STRING)
private BookStatus status;
}