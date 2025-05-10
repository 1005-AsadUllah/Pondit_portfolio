package com.pondit.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pondit.demo.model.domain.Project;
import com.pondit.demo.model.dto.CreateProjectRequest;


@Tag(name="Projects Resources", description = "API for managing project")
@org.springframework.web.bind.annotation.RestController
public class ProjectRestController {

    List<Project> projects = new ArrayList<>();
    @Tag(name="Get All Projects", description = "Get all projects")
    @GetMapping("/api/projects")
    public List<Project> getAllProjects() {
        
        
        return projects;
    }
    @Tag(name = "Create Project")
    @PostMapping("/api/projects")
    public Project createpProject( @RequestBody CreateProjectRequest projectDTO) {
        String name = projectDTO.getName();
        String description = projectDTO.getDescription();

        // TODO : validate the name and description
        // TODO : Bussiness logic
        // TODO : save the project to the database

        Project project = new Project(name, description);
        
        projects.add(project);
       
        return project;
    }
    

}
