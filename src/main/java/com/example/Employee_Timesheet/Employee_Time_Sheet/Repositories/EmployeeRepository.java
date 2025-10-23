package com.example.Employee_Timesheet.Employee_Time_Sheet.Repositories;


import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
