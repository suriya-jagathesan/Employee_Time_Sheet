package com.example.Employee_Timesheet.Employee_Time_Sheet.Repositories;


import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByEmail(String email);
}
