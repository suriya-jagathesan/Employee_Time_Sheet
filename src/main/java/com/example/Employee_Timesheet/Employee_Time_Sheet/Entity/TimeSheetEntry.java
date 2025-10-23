package com.example.Employee_Timesheet.Employee_Time_Sheet.Entity;

import jakarta.persistence.*;
import lombok.Data;



import java.time.LocalDateTime;


@Data
@Entity
public class TimeSheetEntry {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Projects project;
    @Column(nullable = false)
    private LocalDateTime from_time;
    @Column(nullable = false)
    private LocalDateTime to_time;
    private double hours_worked;
    private String description;
}
