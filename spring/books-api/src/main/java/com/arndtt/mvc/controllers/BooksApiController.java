package com.arndtt.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arndtt.mvc.models.Book;
import com.arndtt.mvc.services.BookService;

@RestController
public class BooksApiController {
	private final BookService bookService;
	public BooksApiController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}
	
	@PostMapping("/api/books")
	public Book create(@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="pages") Integer numberOfPages) {
		Book book = new Book(title, description, language, numberOfPages);
		return bookService.createBook(book);
	}
	
	@GetMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	@PutMapping("/api/books/{id}")
	public Book update(
			@PathVariable("id") Long id,
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("pages") Integer numberOfPages) {
		Book book = bookService.updateBook(id, title, description, language, numberOfPages);
		return book;
	}
	
	@DeleteMapping("/api/books/{id}")
	public void delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}
