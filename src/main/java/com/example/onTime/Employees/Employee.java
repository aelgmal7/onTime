package com.example.onTime.Employees;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    private Long employeeId;
    private String userName;
    private Long password;
    private Integer totalPoints;
    private Integer totalAttendanceDays;


}
