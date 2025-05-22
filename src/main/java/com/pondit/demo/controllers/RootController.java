package com.pondit.demo.controllers;

import com.pondit.demo.config.ResumeConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RootController {


    private final ResumeConfig resumeConfig;

    public RootController(ResumeConfig resumeConfig) {
        this.resumeConfig = resumeConfig;
    }
    @Value("${site.title}")
    private String siteTitle;

    @Value("${site.description}")
    private String siteDescription;

    private static Logger log = LoggerFactory.getLogger(RootController.class);

    @GetMapping
        public String indexPage (Model model)

        {

            log.info("setting attribute for index page");
            model.addAttribute("title", siteTitle);
            model.addAttribute("description", siteDescription);
            model.addAttribute("personalInfo", resumeConfig.getPersonalInfo());
            model.addAttribute("educationList", resumeConfig.getEducation());
           model.addAttribute("experienceList", resumeConfig.getExperience());
            model.addAttribute("skills", resumeConfig.getSkills());

            log.info("Rendering index page");
            return "home";
        }
    }
