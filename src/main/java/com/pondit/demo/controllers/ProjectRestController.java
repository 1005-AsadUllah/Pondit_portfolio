package com.pondit.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import com.pondit.demo.service.ProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pondit.demo.model.domain.Project;
import com.pondit.demo.model.dto.CreateProjectRequest;
import org.springframework.web.bind.annotation.RequestMapping;


@Tag(name="Projects Resources", description = "API for managing project")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/projects")
public class ProjectRestController {
    @Autowired
    ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public Project createProject(@RequestBody CreateProjectRequest request) {
        // TODO: validate input
        return projectService.createProject(request);
    }
    

}
