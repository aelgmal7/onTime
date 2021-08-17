package com.example.onTime.dailyRecord;

import com.example.onTime.Employees.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@RestController
@RequestMapping("/record")
public class DailyRecordController {
    public DailyRecordController(DailyRecordService dailyRecordService) {
        this.dailyRecordService = dailyRecordService;
    }

    @Autowired
    private DailyRecordService dailyRecordService;
    @Autowired
    private EmployeeService employeeService;
    private DailyRecord d = DailyRecord.builder()

        .build();
//get all records
    @GetMapping
    private DailyRecord dailyRecord(){
        return d;
    }

    @PostMapping("/r")
    public String  setNewDailyRecord(
           @Param("id") Long id
    ){

       String message= dailyRecordService.addNewDailyRecord(id);
        //employeeService.increaseTotalAttendance(id);
        return message;
    }

}
