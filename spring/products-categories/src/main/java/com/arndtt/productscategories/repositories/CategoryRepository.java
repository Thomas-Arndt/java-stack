package com.arndtt.productscategories.repositories;

import java.util.List;

import com.arndtt.productscategories.models.Category;
import com.arndtt.productscategories.models.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    List<Category> findByProductsNotContaining(Product product);
    
}
