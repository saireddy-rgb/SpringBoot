package com.saireddy.products2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.saireddy.products2.model.Products;
import com.saireddy.products2.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Products> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/products/{prodId}")
    public Products getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public String  addProducts(@RequestBody Products products) {
        new Products(service.addProducts(products));
        return "product details created successfully";
    }

   
    @PutMapping("/products/{prodId}")
    public void updateProducts(@PathVariable long prodId, @RequestBody Products products){
        new Products(service.updateProduct(products,prodId));
    }

    @DeleteMapping("/products/{prodId}")
    public String deleteProduct(@PathVariable long prodId){
        service.deleteProduct(prodId);
        return "product details deleted successfully";
    }

}
