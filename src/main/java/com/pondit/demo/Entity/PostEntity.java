package com.pondit.demo.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Getter
@Setter
public class PostEntity {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    @Setter
    private String title;
    private String slug;
    private String content;

    @Column(name = "is_published")
    private Boolean published;
    private LocalDateTime publishAt;

}
