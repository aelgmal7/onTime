package com.example.onTime.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    //create new user
    public String addNewEmployee(Employee e){
        employeeRepository.save(e);
        return "done";
    }
    //find by id
    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException(" employee not found")
        );
    }

}
