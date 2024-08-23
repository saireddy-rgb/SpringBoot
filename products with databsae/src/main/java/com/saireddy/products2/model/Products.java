package com.saireddy.products2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "products_list")
public class Products {
    @Id
    private long prodId;
    private String prodName;
    private int price;

    public Products() {
    }

    public Products(long prodId, String prodName, int price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
    }

    public Products(Products products) {
    }

    public long getProdId() {
        return prodId;
    }

    public void setProdId(long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", price=" + price +
                '}';
    }
}
