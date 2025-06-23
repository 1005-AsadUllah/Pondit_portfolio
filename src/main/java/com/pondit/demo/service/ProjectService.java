package com.pondit.demo.service;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

import com.pondit.demo.exception.NotFoundException;
import com.pondit.demo.model.dto.UpdateProjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pondit.demo.Entity.ProjectEntity;
import com.pondit.demo.model.domain.Project;
import com.pondit.demo.model.dto.CreateProjectRequest;
import com.pondit.demo.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProjects(Pageable pageable) {

        List<Project> projectList = new ArrayList<>();

        List<ProjectEntity> entityList = (List<ProjectEntity>) projectRepository.findAll(pageable).getContent();
//        BeanUtils.copyProperties(entityList,projectList);
//        return projectList;
        return entityList.stream().map(projectEntity -> {
            Long entityId = projectEntity.getId();
            String entityName = projectEntity.getName();
            String entityDescription = projectEntity.getDescription();
            return new Project(entityId, entityName, entityDescription);
        }).toList();
    }

    public Project createProject(CreateProjectRequest request) {
        // request
        String name = request.name();
        String description = request.description()  ;

        // save to database
        ProjectEntity entity = new ProjectEntity();
        entity.setName(name);
        entity.setDescription(description);
        ProjectEntity savedEntity = projectRepository.save(entity); // create operation

        // map entity to domain object
        Long savedEntityId = savedEntity.getId();
        String savedEntityName = savedEntity.getName();
        String savedEntityDescription = savedEntity.getDescription();
        return new Project(savedEntityId, savedEntityName, savedEntityDescription);
    }

    public Project getProjectById(Long id) throws NotFoundException {

        ProjectEntity projectEntity = projectRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Project not found with id: " + id));
        Long entityId = projectEntity.getId();
        String name = projectEntity.getName();
        String description = projectEntity.getDescription();
        Project project = new Project(entityId, name, description);

        return project;

    }

    public void deleteProjectById(Long id) throws NotFoundException {
        ProjectEntity projectEntity = projectRepository.findById(id).orElse(null);
        if (projectEntity != null) {
            projectRepository.delete(projectEntity);
        } else {
            throw new NotFoundException("Project not found");
        }
    }

    public void updateProject(Long id, UpdateProjectRequest request) throws NotFoundException {
        ProjectEntity projectEntity = projectRepository.findById(id).orElseThrow(() -> new NotFoundException("Project not found with id: " + id));
        projectEntity.setDescription(request.description());
        projectRepository.save(projectEntity);
    }

    public String newProject(ProjectEntity projectEntity) {
        projectRepository.save(projectEntity);
        return "New project created with name: " + projectEntity.getName();
    }

    public ProjectEntity getProject(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project not found with id: " + id));
    }

    public List<ProjectEntity> getAllProject() {
        return (List<ProjectEntity>) projectRepository.findAll();
    }

    public void deleteProject(Long id) {
        ProjectEntity projectEntity = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project not found with id: " + id));
        projectRepository.delete(projectEntity);
    }
}
