package com.pondit.demo.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @GetMapping
    public String indexPage() {
        return "blog/index";
    }

    @GetMapping("{slug}")
    public String detailPage(@PathVariable String slug) {
        return "blog/detail";
    }
}
