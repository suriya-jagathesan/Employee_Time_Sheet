package com.example.Employee_Timesheet.Employee_Time_Sheet.Controller;

import com.example.Employee_Timesheet.Employee_Time_Sheet.DTO.ApiResponse;
import com.example.Employee_Timesheet.Employee_Time_Sheet.DTO.EmplyeeDTO;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.Employee;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.ErrorResponse;
import com.example.Employee_Timesheet.Employee_Time_Sheet.GlobalException.DataNotFoundException;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Repositories.EmployeeRepository;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employess")
    public ResponseEntity<?> getAllEmployees(){
        List<EmplyeeDTO> employee = employeeService.getAllEmployee();
        ApiResponse succes_data =  new ApiResponse(200,"Data Found Sucessfully", employee);
        return new ResponseEntity<>(succes_data,HttpStatus.OK);
    }


    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeebyID(@PathVariable(name = "id") int id1){
        Optional<EmplyeeDTO> empById = employeeService.getEmployeesByID(id1);
        ApiResponse succes_data =  new ApiResponse(200,"Data Found Sucessfully",Arrays.asList(empById));
        return new ResponseEntity<>(succes_data,HttpStatus.OK);

    }
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
        Employee saved_emp = employeeService.addEmployee(emp);
        return ResponseEntity.ok(saved_emp);
    }
    @GetMapping("/employeebyEmail")
    public ResponseEntity<?> getEmployeeByEmail(@RequestParam String email) {
        List<EmplyeeDTO> employee = employeeService.getEmployeesByEmail(email);
//        if (employee.isPresent()) {
////            return ResponseEntity.ok(employee.get());
            ApiResponse succes_data =  new ApiResponse(200,"Data Found Sucessfully", employee);
            return new ResponseEntity<>(succes_data,HttpStatus.OK);
//        } else {
//
//           throw new DataNotFoundException("Employee not found for Email " + email);
//        }
    }


}
