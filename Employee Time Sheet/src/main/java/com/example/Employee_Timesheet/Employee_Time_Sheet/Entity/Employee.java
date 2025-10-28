package com.example.Employee_Timesheet.Employee_Time_Sheet.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private String location;
    private String email;
    private String designation;
    private String status;
    @OneToMany(mappedBy = "employee", orphanRemoval = true)
    private List<TimeSheetEntry> timesheetEntries;
}
