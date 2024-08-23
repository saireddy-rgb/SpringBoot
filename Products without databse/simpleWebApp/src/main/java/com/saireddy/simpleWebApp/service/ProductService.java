package com.saireddy.simpleWebApp.service;

import com.saireddy.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101,"iphone",50000),
            new Product(102,"canon",20000),
            new Product(103,"redmi",10000),
            new Product(104,"mic",1000)));

    public List<Product> getProducts(){
        return products;
    }
    public Product getProductById(int prodId){
        return products.stream()
                .filter(p -> p.getProdId()==prodId)
                .findFirst()
                .orElse(new Product(100,"no item found",0));
    }

    public void addProduct(Product prod){
        products.add(prod);
    }

    public void updateProduct(Product prod) {
        int index = 0;
        for (int i = 0; i < products.size(); i++)
            if (products.get(i).getProdId() == prod.getProdId())
                index = i;
        products.set(index,prod);
    }

    public void deleteProduct(int prodId) {
      int index = 0;
        for (int i = 0; i < products.size(); i++)
            if (products.get(i).getProdId() == prodId)
                index = i;
        products.remove(index);
    }
}
