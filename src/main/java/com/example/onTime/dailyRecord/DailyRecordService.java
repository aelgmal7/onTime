package com.example.onTime.dailyRecord;

import com.example.onTime.Employees.Employee;
import com.example.onTime.Employees.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class DailyRecordService {

    @Autowired
    private DailyRecordRepo dailyRecordRepo;
    @Autowired
    private EmployeeRepository employeeRepository;

    public DailyRecordService(DailyRecordRepo dailyRecordRepo, EmployeeRepository employeeRepository) {
        this.dailyRecordRepo = dailyRecordRepo;
        this.employeeRepository = employeeRepository;
    }

        private Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException(" employee not found")
        );
        }
    //add daily record;
    public void  addNewDailyRecord(
            Long employeeId
            ) {
        Employee employee = findEmployeeById(employeeId);

        if (dailyRecordRepo.findByDateAndEmployee(LocalDate.now(),employee).isPresent()) {
            System.out.println("check out");
            checkOut(employee);
        } else {
            System.out.println("check in");

            System.out.println("employee = " + employee);
            DailyRecord r = DailyRecord.builder()
                    .date(LocalDate.now())
                    .timeIn(LocalTime.now())
                    .employee(employee)
                    .build();
            dailyRecordRepo.save(r);
        }
    }
    //check out Fn
    @Transactional
    public void checkOut(Employee e){
        DailyRecord d = dailyRecordRepo.findByDateAndEmployee(LocalDate.now(),e).orElseThrow();
        System.out.println("d = " + d);
        d.setTimeOut(LocalTime.now());
        System.out.println("d = " + d);
        dailyRecordRepo.save(d);

    }

}
