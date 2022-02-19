package com.arndtt.productscategories.services;

import java.util.List;
import java.util.Optional;

import com.arndtt.productscategories.models.Category;
import com.arndtt.productscategories.models.Product;
import com.arndtt.productscategories.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> allCategories() {
        return categoryRepo.findAll();
    }

    public Category oneCategory(Long id) {
        Optional<Category> potentialCategory = categoryRepo.findById(id);
        if(potentialCategory.isPresent()) {
            return potentialCategory.get();
        }
        return null;
    }

    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    public List<Category> nonProductCategories(Product product) {
        return categoryRepo.findByProductsNotContaining(product);
    }

}
