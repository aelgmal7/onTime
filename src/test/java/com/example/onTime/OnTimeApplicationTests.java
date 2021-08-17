package com.example.onTime;

import com.example.onTime.Employees.EmployeeRepository;
import com.example.onTime.dailyRecord.DailyRecordRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnTimeApplicationTests {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DailyRecordRepo dailyRecordRepo;


	@Test
	void contextLoads() {
	}

}
