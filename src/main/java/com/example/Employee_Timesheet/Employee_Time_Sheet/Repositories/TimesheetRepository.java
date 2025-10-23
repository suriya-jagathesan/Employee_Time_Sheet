package com.example.Employee_Timesheet.Employee_Time_Sheet.Repositories;

import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.TimeSheetEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.util.List;

public interface TimesheetRepository extends JpaRepository<TimeSheetEntry,Long> {

//    Page<TimeSheetEntry> findByEmployeeId(Long employeeId, Pageable pageable);
//
//    List<TimeSheetEntry> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate from, LocalDate to);

//    @Query("SELECT t.project.id, t.project.name, SUM(t.hoursWorked) FROM TimesheetEntry t WHERE t.date BETWEEN :from AND :to GROUP BY t.project.id, t.project.name")
//    List<Object[]> totalHoursPerProject(LocalDate from, LocalDate to);
//
//    @Query("SELECT t.employee.id, t.employee.name, SUM(t.hoursWorked) AS total FROM TimesheetEntry t WHERE t.date BETWEEN :from AND :to GROUP BY t.employee.id, t.employee.name ORDER BY total DESC")
//    List<Object[]> totalHoursPerEmployee(LocalDate from, LocalDate to, Pageable pageable);
}
