package com.arndtt.productscategories.controllers;

import java.util.List;

import com.arndtt.productscategories.models.Category;
import com.arndtt.productscategories.models.Product;
import com.arndtt.productscategories.services.CategoryService;
import com.arndtt.productscategories.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Product> allProducts = productService.allProducts();
        List<Category> allCategories = categoryService.allCategories();
        model.addAttribute("allProducts", allProducts);
        model.addAttribute("allCategories", allCategories);
        return "home.jsp";
    }

    @GetMapping("/products")
    public String productForm(@ModelAttribute("product") Product product) {
        return "productForm.jsp";
    }

    @PostMapping("/products")
    public String createProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/home";
    }

    @GetMapping("/categories")
    public String categoryForm(@ModelAttribute("category") Category category) {
        return "categoryForm.jsp";
    }

    @PostMapping("/categories")
    public String createCategory(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/home";
    }

    @GetMapping("/categories/{id}")
    public String categoryDetails(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.oneCategory(id);
        List<Product> nonCategoryProducts = productService.nonCategoryProducts(category);
        model.addAttribute("category", category);
        model.addAttribute("nonCategoryProducts", nonCategoryProducts);
        return "categoryDetails.jsp";
    }

    @GetMapping("/products/{id}")
    public String productDetails(@PathVariable("id") Long id, Model model) {
        Product product = productService.oneProduct(id);
        List<Category> nonProductCategories = categoryService.nonProductCategories(product);
        model.addAttribute("product", product);
        model.addAttribute("nonProductCategories", nonProductCategories);
        return "productDetails.jsp";
    }

    @PutMapping("/products/{id}/addCategory")
    public String addCategory(@PathVariable("id") Long productId,
        @RequestParam("category") Long categoryId) {
        
        Product product = productService.oneProduct(productId);
        Category category = categoryService.oneCategory(categoryId);
        product.getCategories().add(category);
        productService.saveProduct(product);
        return "redirect:/products/"+productId;
    }

    @PutMapping("categories/{id}/addProduct")
    public String addProduct(@PathVariable("id") Long categoryId,
        @RequestParam("product") Long productId) {

        Category category = categoryService.oneCategory(categoryId);
        Product product = productService.oneProduct(productId);
        category.getProducts().add(product);
        categoryService.saveCategory(category);
        return "redirect:/categories/"+categoryId;
        }

}
