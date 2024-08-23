package com.saireddy.products2.service.impl;

import com.saireddy.products2.Repo.ProductsRepo;
import com.saireddy.products2.model.Products;
import com.saireddy.products2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductsRepo productsRepo;

    @Override
    public Products addProducts(Products products) {
        return productsRepo.save(products);
    }

    @Override
    public List<Products> getAllProducts() {
        return productsRepo.findAll();
    }

    @Override
    public Products getProductById(long prodId) {
        Optional<Products> products = productsRepo.findById(prodId);
        if (products.isPresent()) {
            return products.get();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Products updateProduct(Products products, long prodId) {
        Products existingProduct = productsRepo.findById(prodId).orElseThrow(() -> new RuntimeException());
        existingProduct.setPrice(products.getPrice());
        existingProduct.setProdName(products.getProdName());
        productsRepo.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void deleteProduct(long prodId) {
        productsRepo.findById(prodId).orElseThrow(() -> new RuntimeException());
        productsRepo.deleteById(prodId);
    }
}