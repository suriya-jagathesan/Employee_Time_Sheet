package com.example.Employee_Timesheet.Employee_Time_Sheet.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Projects {
    @Id
    @GeneratedValue
    private int id;
    private String project_name;
    private String project_location;
    private LocalDate start_date;
    private LocalDate end_date;
    private String status;
    // One project can have many timesheet entries
    @OneToMany(mappedBy = "project")
    private List<TimeSheetEntry> timesheetEntries;
}
