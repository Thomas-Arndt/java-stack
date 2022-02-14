package com.arndtt.renderingallbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arndtt.renderingallbooks.models.Book;
import com.arndtt.renderingallbooks.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book updateBook(Long id, String title, String description, String language, Integer numberOfPages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			Book book = optionalBook.get();
			book.setTitle(title);
			book.setDescription(description);
			book.setLanguage(language);
			book.setNumberOfPages(numberOfPages);
			return bookRepository.save(book);
		} else {
			return null;
		}
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
}
