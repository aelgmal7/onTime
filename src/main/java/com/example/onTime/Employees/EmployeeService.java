package com.example.onTime.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        return "employee is created done ";
    }
    //find by id
    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException(" employee not found")
        );
    }
    //update totalAttendance when new daily record added
    @Transactional
    public void increaseTotalAttendance(Long id){
        Employee employee= findEmployeeById(id);
        if (employee.getTotalAttendanceDays() ==null)
            employee.setTotalAttendanceDays(1);
        else {
            Integer newValue = employee.getTotalAttendanceDays() + 1;
            employee.setTotalAttendanceDays(newValue);
        }
        employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

}
