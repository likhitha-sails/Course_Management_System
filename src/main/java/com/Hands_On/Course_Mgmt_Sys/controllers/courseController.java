package com.Hands_On.Course_Mgmt_Sys.controllers;

import com.Hands_On.Course_Mgmt_Sys.models.Course;
import com.Hands_On.Course_Mgmt_Sys.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class courseController {
        @Autowired
        private CourseService courseService;

        // Create a new course
        @PostMapping("/create/{instructorId}")
        public ResponseEntity<Course> createCourse(
                @PathVariable Long instructorId,
                @RequestBody Course course) {
            Course createdCourse = courseService.createCourse(instructorId, course);
            return ResponseEntity.ok(createdCourse);
        }

        // Get all courses
        @GetMapping
        public ResponseEntity<List<Course>> getAllCourses() {
            List<Course> courses = courseService.getAllCourses();
            return ResponseEntity.ok(courses);
        }
}

