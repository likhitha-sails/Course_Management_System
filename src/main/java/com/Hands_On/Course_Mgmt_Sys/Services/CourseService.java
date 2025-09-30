package com.Hands_On.Course_Mgmt_Sys.Services;

import com.Hands_On.Course_Mgmt_Sys.Enums.Role;
import com.Hands_On.Course_Mgmt_Sys.Models.Course;
import com.Hands_On.Course_Mgmt_Sys.Models.Student;

import com.Hands_On.Course_Mgmt_Sys.Models.User;
import com.Hands_On.Course_Mgmt_Sys.Repositories.CourseRepository;
import com.Hands_On.Course_Mgmt_Sys.Repositories.UserRepository;
import org.hibernate.sql.ast.tree.expression.SqlTuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    public Course createCourse(Long instructorId, Course course){
        User instructor=userRepository.findById(instructorId)
                .orElseThrow(()-> new RuntimeException("Instructor not found"));
        if(instructor.getRole()!= Role.INSTRUCTOR && instructor.getRole()!=Role.ADMIN){
            throw new RuntimeException("Only instructors or admins can create courses");
        }
        course.setInstructor(instructor);
        return courseRepository.save(course);
    }
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
}
