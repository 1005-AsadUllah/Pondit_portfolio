package com.pondit.demo.controllers;

import com.pondit.demo.config.ResumeConfig;

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

    @GetMapping
        public String indexPage (Model model)

        {

            model.addAttribute("personalInfo", resumeConfig.getPersonalInfo());
            model.addAttribute("educationList", resumeConfig.getEducation());
           model.addAttribute("experienceList", resumeConfig.getExperience());
            model.addAttribute("skills", resumeConfig.getSkills());

            return "home";
        }
    }
