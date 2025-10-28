package com.example.Employee_Timesheet.Employee_Time_Sheet.Service;

import com.example.Employee_Timesheet.Employee_Time_Sheet.Entity.Projects;
import com.example.Employee_Timesheet.Employee_Time_Sheet.GlobalException.DataNotFoundException;
import com.example.Employee_Timesheet.Employee_Time_Sheet.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public Projects createProject(Projects project) {
        return projectRepository.save(project);
    }

    public Optional<Projects> getProjectByID(int id) {
        Optional<Projects> prj = projectRepository.findById(Long.valueOf(id));
        if( prj.isEmpty() ){
            throw new DataNotFoundException("Data not Found");
        }
        return projectRepository.findById(Long.valueOf(id));
    }

    public List<Projects> getAllProjects() {
        List<Projects> all_project = projectRepository.findAll();
        if( all_project == null ){
            throw new DataNotFoundException("No Projects Found");
        }
        return all_project;
    }
}
