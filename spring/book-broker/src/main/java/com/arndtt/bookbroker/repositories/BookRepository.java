package com.arndtt.bookbroker.repositories;

import java.util.List;

import com.arndtt.bookbroker.models.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findAllByBorrowerIsNullOrderByTitle();
}
