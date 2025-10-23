package com.example.Employee_Timesheet.Employee_Time_Sheet.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;
import org.springframework.stereotype.Repository;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private String location;
    private int email;
    private String designation;
}
