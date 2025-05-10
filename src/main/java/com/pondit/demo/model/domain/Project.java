package com.pondit.demo.model.domain;

public class  Project {
    private final String name;
    private final String description;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
