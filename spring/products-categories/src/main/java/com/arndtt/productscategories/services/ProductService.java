package com.arndtt.productscategories.services;

import java.util.List;
import java.util.Optional;

import com.arndtt.productscategories.models.Category;
import com.arndtt.productscategories.models.Product;
import com.arndtt.productscategories.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepo;

    public List<Product> allProducts() {
        return productRepo.findAll();
    }

    public Product oneProduct(Long id) {
        Optional<Product> potentialProduct = productRepo.findById(id);
        if(potentialProduct.isPresent()) {
            return potentialProduct.get();
        }
        return null;
    }

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> nonCategoryProducts(Category category) {
        return productRepo.findByCategoriesNotContaining(category);
    }
}
