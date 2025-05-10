package com.pondit.demo.repository;

import com.pondit.demo.Entity.ProjectEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {

    
}
