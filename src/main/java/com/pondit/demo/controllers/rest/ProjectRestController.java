package com.pondit.demo.controllers.rest;

import org.springframework.data.domain.Pageable;

import java.util.List;

import com.pondit.demo.exception.NotFoundException;
import com.pondit.demo.model.dto.UpdateProjectRequest;
import com.pondit.demo.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
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
    public List<Project> getAllProjects(@ParameterObject Pageable pageable) {

        return projectService.getAllProjects(pageable);
    }

    // Get a project by ID
    @Operation(summary = "Get a project by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) throws NotFoundException {
        return  ResponseEntity.ok(projectService.getProjectById(id));
    }

    // Update a project by ID
    @Operation(summary = "Update a project by id")
    @PutMapping("{id}")
    public void updateProject(@PathVariable Long id, @RequestBody UpdateProjectRequest request) throws NotFoundException {
        projectService.updateProject(id, request);
    }

    //Delete a project by ID
    @Operation(summary = "Delete a project by ID")
    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable Long id) throws NotFoundException {
        projectService.deleteProjectById(id);
    }
    

}
