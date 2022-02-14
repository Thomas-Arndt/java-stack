package com.arndtt.renderingbooks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arndtt.renderingbooks.models.Book;
import com.arndtt.renderingbooks.services.BookService;

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
}
