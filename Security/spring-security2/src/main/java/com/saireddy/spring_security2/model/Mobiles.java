package com.saireddy.spring_security2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mobiles")
public class Mobiles {
    @Id
    private long mobileId;
    private String mobileName;
    private int mobilePrice;
}
