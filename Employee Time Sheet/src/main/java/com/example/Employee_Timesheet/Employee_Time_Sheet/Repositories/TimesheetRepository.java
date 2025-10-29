package com.example.Employee_Timesheet.Employee_Time_Sheet.Repositories;

import com.example.Employee_Timesheet.Employee_Time_Sheet.DTO.TimeSheetResponseDTO;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.Employee;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.Projects;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.TimeSheetEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TimesheetRepository extends JpaRepository<TimeSheetEntry,Long> {
    Optional<TimeSheetEntry> findByEmployeeAndProjectAndDate(Employee employee, Projects project, LocalDate entryDate);

    @Query("SELECT t FROM TimeSheetEntry t JOIN FETCH t.employee e JOIN FETCH t.project p")
    List<TimeSheetEntry> findAllWithEmployeeAndProject();

}
