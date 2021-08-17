package com.example.onTime.dailyRecord;

import com.example.onTime.Employees.Employee;
import com.example.onTime.Employees.EmployeeRepository;
import com.example.onTime.Employees.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DailyRecordService {
    //imports
    @Autowired
    private DailyRecordRepo dailyRecordRepo;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    public DailyRecordService(DailyRecordRepo dailyRecordRepo, EmployeeRepository employeeRepository) {
        this.dailyRecordRepo = dailyRecordRepo;
        this.employeeRepository = employeeRepository;
    }
    /*
    * main functions
    * */

    //add daily record;
    public String addNewDailyRecord(
            Long employeeId
            ) {
        Employee employee = findEmployeeById(employeeId);

        if (dailyRecordRepo.findByDateAndEmployee(LocalDate.now(),employee).isPresent()) {
            checkOut(employee);
            return "check out ";
        } else {
            employeeService.increaseTotalAttendance(employeeId);

            System.out.println("employee = " + employee);
            DailyRecord r= createNewDailyRecord(employee);
            dailyRecordRepo.save(r);
            return "check in ";
        }
    }
    //get all records
    public List<DailyRecord> getAllRecords(){
        return dailyRecordRepo.findAll();
    }
    public List<DailyRecord> getAllByDate(String s){
//        System.out.println(LocalDate.parse("2021/08/17"));
        return dailyRecordRepo.findAllByDate(LocalDate.parse(s));
    }


    /*
    * sub functions
    * */
    //check out Fn
    @Transactional
    public void checkOut(Employee e){
        DailyRecord d = dailyRecordRepo.findByDateAndEmployee(LocalDate.now(),e).orElseThrow();
        System.out.println("d = " + d);
        d.setTimeOut(LocalTime.now());
        System.out.println("d = " + d);
        dailyRecordRepo.save(d);

    }

    //find employee by id
    private Employee findEmployeeById(Long id){
        return employeeService.findEmployeeById(id);
    }
    //create new daily record
    private DailyRecord createNewDailyRecord(Employee employee){
        DailyRecord r = DailyRecord.builder()
                .date(LocalDate.now())
                .timeIn(LocalTime.now())
                .employee(employee)
                .build();
        return r;
    }

}
