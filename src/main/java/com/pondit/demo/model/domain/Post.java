package com.pondit.demo.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Long id;
    private String title;
    private String slug;
    private String content;

    private Boolean published;
    private LocalDate publishAt;

}
