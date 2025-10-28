package com.example.Employee_Timesheet.Employee_Time_Sheet.Service;

import com.example.Employee_Timesheet.Employee_Time_Sheet.DTO.EmplyeeDTO;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.Employee;
import com.example.Employee_Timesheet.Employee_Time_Sheet.GlobalException.DataNotFoundException;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmplyeeDTO emplyeeDTO;
    public Employee addEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

//    public Optional<EmplyeeDTO> getEmployeeByEmail(String email) {
//        return employeeRepository.findByEmail(email)
//                .map(EmplyeeDTO::new);
//    }
public List<EmplyeeDTO> getEmployeesByEmail(String email) {
    List<Employee> employees = employeeRepository.findByEmail(email);
    if( employees.isEmpty() ){
        throw new DataNotFoundException("No employee found for this Email " + email);
    }

    return employees.stream()
            .map(EmplyeeDTO::new)
            .collect(Collectors.toList());
}

    public List<EmplyeeDTO> getAllEmployee() {
        List<Employee> all_employee = employeeRepository.findAll();
        if( all_employee.isEmpty() ){
            throw new DataNotFoundException("No Employee Found");
        }
        return all_employee.stream()
                .map(EmplyeeDTO::new)
                .toList();
    }
//    public String updateEmployeeByID(int ids){
//       boolean emp_exhist = employeeRepository.existsById((long) ids);
//       if( !emp_exhist ){
//           throw new DataNotFoundException("No Employee Found");
//       }
//
//    }

    public Optional<EmplyeeDTO> getEmployeesByID(int id1) {
        Optional<Employee> empByID = employeeRepository.findById(Long.valueOf(id1));
        if( empByID.isEmpty() ){
            throw new DataNotFoundException("No Employee Found");
        }
        return empByID
                .map(EmplyeeDTO::new);
    }

    public void deleteEmployeeById(int id) {
        Optional<Employee> empByID = employeeRepository.findById(Long.valueOf(id));
        if( empByID.isEmpty() ){
            throw new DataNotFoundException("No Employee Found");
        }
        System.out.println(empByID);
        employeeRepository.deleteById(Long.valueOf(id));
    }

    public EmplyeeDTO updateEmployee(Employee updEmp) {
        Employee e = employeeRepository.save(updEmp);
        return new EmplyeeDTO(e);
    }
}
