package com.example.onTime.dailyRecord;

import com.example.onTime.Employees.Employee;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "employee")
@Builder
public class DailyRecord {
    @Id
    @SequenceGenerator(
            name = "daily_sequence",
            sequenceName = "daily_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "daily_sequence"
    )
    private Long recordId;
    private LocalDate date;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private Integer points;
    @ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "employeeId"
    )
    private Employee employee;

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
