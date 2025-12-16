package com.first.Ecom_Catalog_API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.Ecom_Catalog_API.model.Product;
import com.first.Ecom_Catalog_API.service.ProductService;

@RestController
@RequestMapping("/api")

public class ProductController {

    @Autowired
    private ProductService service;

    public ProductController() {
    }
    
    @RequestMapping("/")
    public String greet(){
        return "Welcome to Ecom Catalog API";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
        // Logic to fetch and return all products
    }

}