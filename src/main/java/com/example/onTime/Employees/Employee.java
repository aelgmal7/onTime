package com.example.onTime.Employees;

import com.example.onTime.dailyRecord.DailyRecord;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude ="dailyRecord")
@Builder
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long employeeId;
    private String userName;
    private Long password;
    private Integer totalPoints;
    private Integer totalAttendanceDays;



}
