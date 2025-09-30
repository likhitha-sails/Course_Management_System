package com.Hands_On.Course_Mgmt_Sys.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String createCourse() {
        return "Course created!";
    }
}

