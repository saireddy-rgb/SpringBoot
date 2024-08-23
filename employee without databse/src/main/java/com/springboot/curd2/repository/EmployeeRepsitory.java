package com.springboot.curd2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.curd2.model.Employee;

public interface EmployeeRepsitory extends JpaRepository<Employee,Long> {
    //curd

}
