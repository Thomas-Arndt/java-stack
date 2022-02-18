package com.arndtt.bookclub.services;

import java.util.List;
import java.util.Optional;

import com.arndtt.bookclub.models.Book;
import com.arndtt.bookclub.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepo;

    public List<Book> allBooks() {
        return bookRepo.findAll();
    }

    public Book oneBook(Long id) {
        Optional<Book> potentialBook = bookRepo.findById(id);
        if(potentialBook.isPresent()) {
            return potentialBook.get();
        }
        return null;
    }

    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

}
