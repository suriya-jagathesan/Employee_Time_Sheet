package com.example.Employee_Timesheet.Employee_Time_Sheet.Repositories;

import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Projects,Long> {
}
