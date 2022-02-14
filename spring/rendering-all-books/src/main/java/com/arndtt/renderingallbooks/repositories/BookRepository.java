package com.arndtt.renderingallbooks.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arndtt.renderingallbooks.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findAll();
	
}
