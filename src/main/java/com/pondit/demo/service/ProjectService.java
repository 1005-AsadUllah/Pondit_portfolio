package com.pondit.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

    public List<Project> getAllProjects() {

        List<Project> projectList = new ArrayList<>();

        List<ProjectEntity> entityList = (List<ProjectEntity>) projectRepository.findAll();
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
        String name = request.getName();
        String description = request.getDescription();

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

    public Project getProjectById(Long id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElse(null);
        Long entityid = projectEntity.getId();
        String name = projectEntity.getName();
        String description = projectEntity.getDescription();
        Project project = new Project(entityid, name, description);

        return project;

    }

    public void deleteProjectById(Long id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElse(null);
        if (projectEntity != null) {
            projectRepository.delete(projectEntity);
        } else {
            throw new RuntimeException("Project not found");
        }
    }
}
