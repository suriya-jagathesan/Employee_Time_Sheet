package com.example.Employee_Timesheet.Employee_Time_Sheet.DTO;

import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EmplyeeDTO {
    private int id;
    private String name;
    private int age;
    private String location;
    private String email;
    private String designation;
    private String status;
    public EmplyeeDTO(){

    }
    public EmplyeeDTO(Employee e) {
        this.id = e.getId();
        this.name = e.getName();
        this.age = e.getAge();
        this.location = e.getLocation();
        this.email = e.getEmail();
        this.designation = e.getDesignation();
        this.status = e.getStatus();
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getLocation() { return location; }
    public String getEmail() { return email; }
    public String getDesignation() { return designation; }
    public String getStatus() { return status; }
}
