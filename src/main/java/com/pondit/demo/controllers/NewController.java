package com.pondit.demo.controllers;


import com.pondit.demo.Entity.ProjectEntity;
import com.pondit.demo.model.domain.Project;

import com.pondit.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/new")
public class NewController {

//  dependency injection
    @Autowired
    ProjectService projectService;

    @PostMapping
    public String newProject( @RequestBody ProjectEntity projectEntity) {
        projectService.newProject(projectEntity);
        return "New project created "+ projectEntity.getName();
    }

    @GetMapping("/{id}")
    public ProjectEntity getProjectById(@PathVariable Long id){
        return projectService.getProject(id);
    }

    @GetMapping
    public List<ProjectEntity> getAllProjects() {
        return projectService.getAllProject();
    }

    @DeleteMapping("/{id}")
    public String deleteProjectById(@PathVariable Long id){
        projectService.deleteProject(id);
        return "Project with id " + id + " deleted successfully";
    }
}

