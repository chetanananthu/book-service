package com.example.book_service.controller;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_service.entity.Books;
import com.example.book_service.repository.BookRepository;

@RestController
@RequestMapping("api")
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping
	public List<Books> getAllBook(){
		List<Books> books=bookRepository.findAll();
		return books;
	}
	
	@GetMapping("{id}")
	public Books getABook(@PathVariable("id") long id) {
		Optional<Books> book=bookRepository.findById(id);
		return book.get();
	}
	
	@PostMapping
	public Books addBook(@RequestBody Books book) {
		bookRepository.save(book);
		return book;
	}
}
