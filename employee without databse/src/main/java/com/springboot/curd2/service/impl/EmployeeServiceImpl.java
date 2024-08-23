package com.springboot.curd2.service.impl;

import com.springboot.curd2.model.Employee;
import com.springboot.curd2.repository.EmployeeRepsitory;
import com.springboot.curd2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepsitory employeeRepsitory;

    @Override
    public Employee saveEmployee(Employee employee) {
       return employeeRepsitory.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepsitory.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepsitory.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new RuntimeException();
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepsitory.findById(id).orElseThrow(()-> new RuntimeException());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepsitory.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepsitory.findById(id).orElseThrow(()-> new RuntimeException());
        employeeRepsitory.deleteById(id);
    }
}
