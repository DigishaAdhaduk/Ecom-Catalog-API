package com.first.Ecom_Catalog_API.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.Ecom_Catalog_API.model.Product;
import com.first.Ecom_Catalog_API.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;
    
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

}
