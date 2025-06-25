package com.pondit.demo.controllers.rest;

import com.pondit.demo.model.domain.Post;
import com.pondit.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import com.pondit.demo.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;




@Tag(name="Posts Resources", description = "API for managing post")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // Get all projects
    @Operation(summary = "Get all projects")
    @GetMapping
    public List<Post> getAllPost(@ParameterObject Pageable pageable) {

        return postService.getAllPosts(pageable);
    }


}
