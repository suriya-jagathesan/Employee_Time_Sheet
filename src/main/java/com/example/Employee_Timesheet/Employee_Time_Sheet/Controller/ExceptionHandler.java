package com.example.Employee_Timesheet.Employee_Time_Sheet.Controller;

import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.ErrorResponse;
import com.example.Employee_Timesheet.Employee_Time_Sheet.GlobalException.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> dataNotFoundException(DataNotFoundException e){
        ErrorResponse err_res =  new ErrorResponse(LocalDateTime.now(),301,e.getMessage());
        return new ResponseEntity<>(err_res, HttpStatus.NOT_FOUND);
    }
}
