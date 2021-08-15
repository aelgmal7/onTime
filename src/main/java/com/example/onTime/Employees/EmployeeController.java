package com.example.onTime.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class EmployeeController {
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    Employee e = Employee.builder()
            .employeeId(1L)
            .password(565L)
            .build();
    @GetMapping
    public Employee uuid(){
      return e;

    }
}
