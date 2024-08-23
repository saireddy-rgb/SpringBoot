package com.saireddy.products2.service;

import com.saireddy.products2.model.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
        Products addProducts(Products products);
        List<Products> getAllProducts();
        Products getProductById(long prodId);
        Products updateProduct(Products products, long id);
        void deleteProduct(long prodId);
}
