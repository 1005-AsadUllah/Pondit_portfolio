package com.pondit.demo.controllers;

import java.util.ArrayList;
import java.util.List;

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

    @Operation(summary = "Create a new project")
    @PostMapping
    public Project createProject(@RequestBody CreateProjectRequest request) {
        // TODO: validate input
        return projectService.createProject(request);
    }

    @Operation(summary = "Get all projects")
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @Operation(summary = "Get a project by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        try {
            Project project = projectService.getProjectById(id);
            if (project != null) {
                return ResponseEntity.ok(project);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);

        }
    }

    @Operation(summary = "Delete a project by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProjectById(@PathVariable Long id) {
        try {
            projectService.deleteProjectById(id);
            return ResponseEntity.ok("Project deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting project");
        }
    }
    

}
