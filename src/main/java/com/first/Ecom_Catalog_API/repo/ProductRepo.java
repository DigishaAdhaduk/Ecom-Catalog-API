package com.first.Ecom_Catalog_API.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.Ecom_Catalog_API.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
