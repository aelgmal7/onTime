package com.example.onTime.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class EmployeeController {
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
        private EmployeeService employeeService;


    Employee e = Employee.builder()
            .employeeId(1L)
            .password(565L)
            .build();
    @GetMapping
    public UUID uuid(){
        UUID uuid =  UUID.randomUUID();
      return uuid;

    }

    @PostMapping("/addNewE")
    public void setNewEmployee(@RequestBody Employee e){
    employeeService.addNewEmployee(e);

    }
    @GetMapping("/{id}")
    public Employee getOneEmployee(@PathVariable("id") Long id){
        return employeeService.findEmployeeById(id);
    }
}
