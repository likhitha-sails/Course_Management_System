package com.Hands_On.Course_Mgmt_Sys.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping
    public String enrollCourse() {
        return "Course enrolled!";
    }
}

