package com.pondit.demo.controllers.web;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class RootController {

    @GetMapping
        public String indexPage (Model model)

        {
            log.info("Rendering index page");
            return "blog/index";
        }
    }
