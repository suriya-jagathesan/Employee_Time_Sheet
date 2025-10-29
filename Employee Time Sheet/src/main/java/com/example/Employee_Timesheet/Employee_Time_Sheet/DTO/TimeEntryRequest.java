package com.example.Employee_Timesheet.Employee_Time_Sheet.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Data
public class TimeEntryRequest {
    private Long employeeId;
    private Long projectId;
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;
    private LocalDate date;
}
