package com.pondit.demo.service;

import com.pondit.demo.Entity.PostEntity;
import com.pondit.demo.Entity.ProjectEntity;
import com.pondit.demo.exception.NotFoundException;
import com.pondit.demo.model.domain.Post;
import com.pondit.demo.model.domain.Project;
import com.pondit.demo.model.dto.CreateProjectRequest;
import com.pondit.demo.model.dto.UpdateProjectRequest;
import com.pondit.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getAllPosts(Pageable pageable) {

        List<PostEntity> entityList =postRepository.findAll(pageable).getContent();
//        BeanUtils.copyProperties(entityList,projectList);
//        return projectList;
        return entityList.stream().map(postEntity -> {
            Long entityId = postEntity.getId();
            String entityTitle = postEntity.getTitle();
            String entityContent = postEntity.getContent();
            String entitySlug = postEntity.getSlug();
            Boolean entityPublished = postEntity.getPublished();
            LocalDateTime entityPublishAt = postEntity.getPublishAt();
            Post post = new Post();
            post.setId(entityId);
            post.setTitle(entityTitle);
            post.setContent(entityContent);
            post.setSlug(entitySlug);
            post.setPublished(entityPublished);
            post.setPublishAt(entityPublishAt != null ? entityPublishAt.toLocalDate() : null);
            return post;
        }).toList();
    }
//
//    public Project createProject(CreateProjectRequest request) {
//        // request
//        String name = request.name();
//        String description = request.description()  ;
//
//        // save to database
//        ProjectEntity entity = new ProjectEntity();
//        entity.setName(name);
//        entity.setDescription(description);
//        ProjectEntity savedEntity = projectRepository.save(entity); // create operation
//
//        // map entity to domain object
//        Long savedEntityId = savedEntity.getId();
//        String savedEntityName = savedEntity.getName();
//        String savedEntityDescription = savedEntity.getDescription();
//        return new Project(savedEntityId, savedEntityName, savedEntityDescription);
//    }
//
//    public Project getProjectById(Long id) throws NotFoundException {
//
//        ProjectEntity projectEntity = projectRepository
//                .findById(id)
//                .orElseThrow(() -> new NotFoundException("Project not found with id: " + id));
//        Long entityId = projectEntity.getId();
//        String name = projectEntity.getName();
//        String description = projectEntity.getDescription();
//        Project project = new Project(entityId, name, description);
//
//        return project;
//
//    }
//
//    public void deleteProjectById(Long id) throws NotFoundException {
//        ProjectEntity projectEntity = projectRepository.findById(id).orElse(null);
//        if (projectEntity != null) {
//            projectRepository.delete(projectEntity);
//        } else {
//            throw new NotFoundException("Project not found");
//        }
//    }
//
//    public void updateProject(Long id, UpdateProjectRequest request) throws NotFoundException {
//        ProjectEntity projectEntity = projectRepository.findById(id).orElseThrow(() -> new NotFoundException("Project not found with id: " + id));
//        projectEntity.setDescription(request.description());
//        projectRepository.save(projectEntity);
//    }
}
