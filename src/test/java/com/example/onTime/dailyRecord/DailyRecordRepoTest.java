package com.example.onTime.dailyRecord;

import com.example.onTime.Employees.Employee;
import com.example.onTime.Employees.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DailyRecordRepoTest {
    @Autowired
    private DailyRecordRepo dailyRecordRepo;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    public void  addNewDailyRecord( ) {
        Employee employee = Employee.builder()
                .userName("sss")
                .password(5555L)
                .totalAttendanceDays(56)
                .build();
        employeeRepository.save(employee);
       Employee s = employeeRepository.findById(1L).orElseThrow()
        ;
        System.out.println("employee = " + employee);
        DailyRecord r = DailyRecord.builder()
                .date(LocalDate.now())
                .timeIn(LocalTime.now())
                .employee(s)
                .build();
        dailyRecordRepo.save(r);
    }
    @Test
    public void s(){
        LocalDate s = LocalDate.parse("2018-12-27");
        System.out.println("s = " + s);
    }

//    @Test
//    public void  ss(){
//         Employee s= employeeRepository.findById(1L).orElseThrow();
//        DailyRecord d= dailyRecordRepo.findByDateAndEmployee(LocalDate.now(),s);
//        System.out.println("s = " + d);
//
//    }

}