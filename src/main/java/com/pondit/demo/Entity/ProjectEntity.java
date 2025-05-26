package com.pondit.demo.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "project")
@Entity
@Getter
public class ProjectEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Setter
    private String name;

    @Setter
    private String description;



}
