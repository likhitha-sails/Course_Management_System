package com.Hands_On.Course_Mgmt_Sys.services;

import com.Hands_On.Course_Mgmt_Sys.enums.Role;
import com.Hands_On.Course_Mgmt_Sys.models.Course;
import com.Hands_On.Course_Mgmt_Sys.models.Enroll;
import com.Hands_On.Course_Mgmt_Sys.models.User;
import com.Hands_On.Course_Mgmt_Sys.repositories.CourseRepository;
import com.Hands_On.Course_Mgmt_Sys.repositories.EnrollmentRepository;
import com.Hands_On.Course_Mgmt_Sys.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Enroll enrollStudent(Long userId, Long courseId) {
        // Fetch the User who is enrolling
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Only allow STUDENT or ADMIN to enroll
        if (user.getRole() != Role.STUDENT && user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only STUDENT or ADMIN roles can enroll");
        }

        // Fetch the Course
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Create enrollment
        Enroll enroll = new Enroll();
        enroll.setStudent(user);  // Link enrollment to User
        enroll.setCourse(course);

        return enrollmentRepository.save(enroll);
    }
}
