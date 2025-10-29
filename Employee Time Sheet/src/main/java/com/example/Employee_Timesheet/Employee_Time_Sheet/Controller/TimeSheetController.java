package com.example.Employee_Timesheet.Employee_Time_Sheet.Controller;

import com.example.Employee_Timesheet.Employee_Time_Sheet.DTO.ApiResponse;
import com.example.Employee_Timesheet.Employee_Time_Sheet.DTO.TimeEntryRequest;
import com.example.Employee_Timesheet.Employee_Time_Sheet.DTO.TimeSheetResponseDTO;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.TimeSheetEntry;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class TimeSheetController {
    @Autowired
    TimeSheetService timeSheetService;
    @PostMapping("/timesheet/clock-in")
    public ResponseEntity<?> addClockIn(@RequestBody TimeEntryRequest timeSheetEntry){
        TimeSheetEntry time = timeSheetService.addClockIn(timeSheetEntry);
        ApiResponse api = new ApiResponse(200,"Clock In Added Sucessfuly", Arrays.asList(timeSheetEntry));
        return new ResponseEntity<>(api, HttpStatus.OK);
    }
    @PostMapping("/timesheets/clock-out")
    public ResponseEntity<?> updateClockIn(@RequestBody TimeEntryRequest timeSheetEntry){
        TimeSheetEntry time = timeSheetService.clockOut(timeSheetEntry);
        ApiResponse api = new ApiResponse(200,"Clock In Updated Sucessfuly", Arrays.asList(timeSheetEntry));
        return new ResponseEntity<>(api, HttpStatus.OK);
    }
    @GetMapping("/timesheets")
    public ResponseEntity<?> getAllTimeSheet(){
        List<TimeSheetResponseDTO> timeSheets = timeSheetService.getAllTimeSheets();
        ApiResponse response = new ApiResponse(200, "Timesheet data fetched successfully", timeSheets);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
