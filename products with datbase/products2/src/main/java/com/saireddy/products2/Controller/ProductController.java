package com.saireddy.products2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saireddy.products2.model.Products;
import com.saireddy.products2.service.ProductService;

// this is a controller that connects to the client and service to the data
@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Products> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/products/{prodId}")
//    this gets the product by Id
    public Products getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public String  addProducts(@RequestBody Products products) {
        new Products(service.addProducts(products));
        return "product details created successfully";
    }

   
    @PutMapping("/products/{prodId}")
//    this updates the details of the product
    public void updateProducts(@PathVariable long prodId, @RequestBody Products products){
        new Products(service.updateProduct(products,prodId));
    }

    @DeleteMapping("/products/{prodId}")
    // this function deletes the product details
    public String deleteProduct(@PathVariable long prodId){
        service.deleteProduct(prodId);
        return "product details deleted successfully";
    }
}
