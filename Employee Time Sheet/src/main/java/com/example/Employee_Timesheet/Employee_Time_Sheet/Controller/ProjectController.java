package com.example.Employee_Timesheet.Employee_Time_Sheet.Controller;

import com.example.Employee_Timesheet.Employee_Time_Sheet.DTO.ApiResponse;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.Projects;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<?> getAllProjects(){
       List<Projects> all_projects =  projectService.getAllProjects();
       ApiResponse api = new ApiResponse(200,"Data found Sucessfully",all_projects);
       return new ResponseEntity<>(api,HttpStatus.OK);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<?> getProjectByID(@PathVariable int id){
        Optional<Projects> projects = projectService.getProjectByID(id);
        ApiResponse api = new ApiResponse(200,"Data found Sucessfully",List.of(projects.get()));
        return new ResponseEntity<>(api,HttpStatus.OK);
    }

    @PostMapping("/projects")
    public ResponseEntity<?> createProject(@RequestBody Projects project){
        Projects add_project = projectService.createProject(project);
        ApiResponse api = new ApiResponse(200,"Project Added Sucessfully", List.of(project));
        return new ResponseEntity<>(api, HttpStatus.OK);
    }
}
