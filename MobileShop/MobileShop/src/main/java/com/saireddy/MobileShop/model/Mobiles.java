package com.saireddy.MobileShop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "mobiles")
public class Mobiles {
    @Id
    private String mobileId;
    private String mobileName;
    private int price;

    public Mobiles() {
    }

    public Mobiles(String mobileId, int price, String mobileName) {
        this.mobileId = mobileId;
        this.price = price;
        this.mobileName = mobileName;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mobiles{" +
                "mobileId='" + mobileId + '\'' +
                ", mobileName='" + mobileName + '\'' +
                ", price=" + price +
                '}';
    }
}
