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
    @ManyToOne(optional = false)
    private Employee employee;

    // Each entry belongs to one project
    @ManyToOne(optional = false)
    private Projects project;


    @Column(nullable = false)
    private LocalDateTime from_time;
    @Column(nullable = false)
    private LocalDateTime to_time;
    private double hours_worked;
    private String description;
}
