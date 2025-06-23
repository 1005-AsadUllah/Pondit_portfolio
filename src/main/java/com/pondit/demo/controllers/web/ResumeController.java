package com.pondit.demo.controllers.web;

import com.pondit.demo.config.ResumeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resume")
public class ResumeController {
    private final ResumeConfig resumeConfig;

    public ResumeController(ResumeConfig resumeConfig) {
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
        return "resume/index";
    }
}


