package com.springboot.curd2.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email_id", nullable = false)
    private  String email;

}
