package com.springboot.curd2.service;

import com.springboot.curd2.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee,long id);
    void deleteEmployee(long id);

}
