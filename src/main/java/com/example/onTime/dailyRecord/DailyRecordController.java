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
import java.util.List;

@RestController
@RequestMapping("/record")
public class DailyRecordController {
    public DailyRecordController(DailyRecordService dailyRecordService) {
        this.dailyRecordService = dailyRecordService;
    }
    //imports
    @Autowired
    private DailyRecordService dailyRecordService;
    @Autowired
    private EmployeeService employeeService;
//get all records
    @GetMapping
    private List<DailyRecord> dailyRecord(){

        return dailyRecordService.getAllRecords();
    }
    //get records by date
    @GetMapping("bydate/{date}")
    public List<DailyRecord> getAllDate(@PathVariable("date") String s){
        return dailyRecordService.getAllByDate(s);
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
