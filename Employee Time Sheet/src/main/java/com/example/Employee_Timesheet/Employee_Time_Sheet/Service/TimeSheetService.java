package com.example.Employee_Timesheet.Employee_Time_Sheet.Service;

import com.example.Employee_Timesheet.Employee_Time_Sheet.DTO.TimeEntryRequest;
import com.example.Employee_Timesheet.Employee_Time_Sheet.DTO.TimeSheetResponseDTO;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.Employee;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.Projects;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.TimeSheetEntry;
import com.example.Employee_Timesheet.Employee_Time_Sheet.GlobalException.DataNotFoundException;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Repositories.EmployeeRepository;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Repositories.ProjectRepository;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Repositories.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TimeSheetService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    TimesheetRepository timesheetRepository;

    public TimeSheetEntry clockOut(TimeEntryRequest request) {
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new DataNotFoundException("Employee not found with ID: " + request.getEmployeeId()));

        Projects project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new DataNotFoundException("Project not found with ID: " + request.getProjectId()));

        if (request.getClockOutTime() == null) {
            throw new DataNotFoundException("Clock-out time is required");
        }

        LocalDate entryDate = request.getClockOutTime().toLocalDate();

        TimeSheetEntry entry = timesheetRepository
                .findByEmployeeAndProjectAndDate(employee, project, entryDate)
                .orElseThrow(() -> new DataNotFoundException("No clock-in found for this date"));

        if (entry.getTo_time() != null) {
            throw new DataNotFoundException("Already clocked out for this date");
        }

        entry.setTo_time(request.getClockOutTime());

        double hours = Duration.between(entry.getFrom_time(), entry.getTo_time()).toMinutes() / 60.0;
        entry.setHours_worked(Math.round(hours * 100.0) / 100.0);

        return timesheetRepository.save(entry);
    }

    public TimeSheetEntry addClockIn(TimeEntryRequest request) {
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new DataNotFoundException("Employee not found with ID: " + request.getEmployeeId()));

        Projects project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new DataNotFoundException("Project not found with ID: " + request.getProjectId()));

        if (request.getClockInTime() == null) {
            throw new DataNotFoundException("Clock-in time is required");
        }
        LocalDate entryDate = request.getClockInTime().toLocalDate();

        Optional<TimeSheetEntry> existing = timesheetRepository.findByEmployeeAndProjectAndDate(employee, project, entryDate);
        if (existing.isPresent()) {
            throw new DataNotFoundException("Employee already has a timesheet entry for this date.");
        }

        TimeSheetEntry entry = new TimeSheetEntry();
        entry.setEmployee(employee);
        entry.setProject(project);
        entry.setDate(entryDate);
        entry.setFrom_time(request.getClockInTime());

        return timesheetRepository.save(entry);

    }

    public List<TimeSheetResponseDTO> getAllTimeSheets() {
        List<TimeSheetEntry> entries = timesheetRepository.findAllWithEmployeeAndProject();

        return entries.stream()
                .map(entry -> new TimeSheetResponseDTO(
                        (long) entry.getId(),
                        entry.getDate(),
                        entry.getFrom_time(),
                        entry.getTo_time(),
                        entry.getHours_worked(),
                        entry.getEmployee() != null ? entry.getEmployee().getName() : null,
                        entry.getProject() != null ? entry.getProject().getProject_name() : null
                ))
                .collect(Collectors.toList());
    }
}
