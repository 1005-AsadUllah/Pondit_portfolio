package com.pondit.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import com.pondit.demo.exception.NotFoundException;
import com.pondit.demo.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pondit.demo.model.domain.Project;
import com.pondit.demo.model.dto.CreateProjectRequest;


@Tag(name="Projects Resources", description = "API for managing project")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/projects")
public class ProjectRestController {
    @Autowired
    ProjectService projectService;


    //create a new project
    @Operation(summary = "Create a new project")
    @PostMapping
    public Project createProject(@RequestBody CreateProjectRequest request) {
        // TODO: validate input
        return projectService.createProject(request);
    }

    // Get all projects
    @Operation(summary = "Get all projects")
    @GetMapping
    public List<Project> getAllProjects() {

        return projectService.getAllProjects();
    }

    // Get a project by ID
    @Operation(summary = "Get a project by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) throws NotFoundException {
        return  ResponseEntity.ok(projectService.getProjectById(id));
    }


    //Delete a project by ID
    @Operation(summary = "Delete a project by ID")
    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable Long id) throws NotFoundException {
        projectService.deleteProjectById(id);
    }
    

}
