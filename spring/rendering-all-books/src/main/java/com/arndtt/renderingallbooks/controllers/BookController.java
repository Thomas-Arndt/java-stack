package com.arndtt.renderingallbooks.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arndtt.renderingallbooks.models.Book;
import com.arndtt.renderingallbooks.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books/{id}")
	public String showBooks(@PathVariable("id") Long id,
			Model model) {
		Book book = bookService.findBook(id);
		if (book != null) {
			model.addAttribute("title", book.getTitle());
			model.addAttribute("description", book.getDescription());
			model.addAttribute("language", book.getLanguage());
			model.addAttribute("numberOfPages", book.getNumberOfPages());
		}
		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String books(Model model) {
		List<Book> allBooks = bookService.allBooks();
		model.addAttribute("allBooks", allBooks);
		return "books.jsp";
	}
}
