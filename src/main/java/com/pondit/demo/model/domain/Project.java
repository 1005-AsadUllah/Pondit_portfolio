package com.pondit.demo.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private  Long id;
    private  String name;
    private  String description;

}
