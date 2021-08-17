package com.example.onTime.dailyRecord;

import com.example.onTime.Employees.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DailyRecordRepo extends JpaRepository<DailyRecord,Long> {
     Optional<DailyRecord> findDailyRecordByDate(LocalDate d);
     Optional<DailyRecord> findByDateAndEmployee(LocalDate d, Employee employee);
     List<DailyRecord> findAllByDate(LocalDate localDate);

}
