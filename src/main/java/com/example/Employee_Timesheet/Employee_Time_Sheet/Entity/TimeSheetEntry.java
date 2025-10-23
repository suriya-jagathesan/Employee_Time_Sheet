package com.example.Employee_Timesheet.Employee_Time_Sheet.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
public class TimeSheetEntry {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Employee employee;
    private Projects project;
    @Column(nullable = false)
    private LocalDateTime from_time;
    @Column(nullable = false)
    private LocalDateTime to_time;
    private double hours_worked;
    private String description;
}
