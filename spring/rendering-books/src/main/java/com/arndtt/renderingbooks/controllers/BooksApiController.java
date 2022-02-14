package com.arndtt.renderingbooks.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arndtt.renderingbooks.models.Book;
import com.arndtt.renderingbooks.services.BookService;

@RestController
@RequestMapping("/api")
public class BooksApiController {
	private final BookService bookService;
	
	public BooksApiController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.allBooks();
	}
	
	@PostMapping("/books")
	public Book create(@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="numberOfPages") Integer numberOfPages) {
		Book book = new Book(title, description, language, numberOfPages);
		return bookService.createBook(book);
	}
	
	@PutMapping("/books/{id}")
	public Book update(@PathVariable("id") Long id,
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="numberOfPages") Integer numberOfPages) {
		return bookService.updateBook(id, title, description, language, numberOfPages);
	}
	
	@DeleteMapping("/books/{id}")
	public void delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
}
