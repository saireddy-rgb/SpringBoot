package com.springboot.curd2.controller;

import com.springboot.curd2.model.Employee;
import  com.springboot.curd2.service.EmployeeService;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.http.HttpStatus;
import  org.springframework.http.ResponseEntity;
import  org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeID){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeID),HttpStatus.OK);
    }

    @PutMapping("{id}")
        public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
            return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
        public  ResponseEntity<String> deleteEmployee(@PathVariable("id") long id ){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted sucessfully.", HttpStatus.OK);
    }
}
