package com.pondit.demo.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RootController {
    static class PersonalInfo {
        private String name;
        private String email;
        private String linkedinUrl;
        private String githubUrl;

        public PersonalInfo(String name, String email, String linkedinUrl, String githubUrl) {
            this.name = name;
            this.email = email;
            this.linkedinUrl = linkedinUrl;
            this.githubUrl = githubUrl;
        }

        // Getters
        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getLinkedinUrl() {
            return linkedinUrl;
        }

        public String getGithubUrl() {
            return githubUrl;
        }
    }

    static class Education {
        private String degree;
        private String institution;
        private String years;
        private String description;

        public Education(String degree, String institution, String years, String description) {
            this.degree = degree;
            this.institution = institution;
            this.years = years;
            this.description = description;
        }

        // Getters
        public String getDegree() {
            return degree;
        }

        public String getInstitution() {
            return institution;
        }

        public String getYears() {
            return years;
        }

        public String getDescription() {
            return description;
        }
    }

    static class Experience {
        private String title;
        private String company;
        private String years;
        private String description;

        public Experience(String title, String company, String years, String description) {
            this.title = title;
            this.company = company;
            this.years = years;
            this.description = description;
        }

        // Getters
        public String getTitle() {
            return title;
        }

        public String getCompany() {
            return company;
        }

        public String getYears() {
            return years;
        }

        public String getDescription() {
            return description;
        }
    }

    @GetMapping
        public String indexPage (Model model)

        {
            // Personal Info
           PersonalInfo personalInfo = new PersonalInfo(
                "Asad Ullah",
                "asadmahmud211@gamil.com",
                "https://www.linkedin.com/in/asad-ullah-0a0577291/",
                "https://github.com/1005-AsadUllah"
           );

            // Education
            List<Education> educationList = Arrays.asList(
                new Education("Diploma in Computer Science and Technology", "Bangladesh Sweden Polytechnic Institute", "2021-2025", "GPA: 3.8/4.0"),
                new Education("SSC", "Abutorab High School", "2016 - 2020", "GPA: 4.83/5.0")
            );

            // Experience
            List<Experience> experienceList = Arrays.asList(
                new Experience("Software Engineer Intern", "Tech Company A", "June 2022 - August 2022", "Worked on developing web applications using Java and Spring Boot."),
                new Experience("Freelance Developer", "Self-Employed", "January 2021 - May 2022", "Developed various projects including a personal portfolio website.")
            );
            List<String> skills = Arrays.asList("Java", "Spring Boot", "Microservices", "MySQL", "Thymeleaf", "Tailwind CSS");
            model.addAttribute("educationList", educationList);
            model.addAttribute("experienceList", experienceList);
           model.addAttribute("personalInfo", personalInfo);
            model.addAttribute("skills", skills);

            return "home";
        }
    }
