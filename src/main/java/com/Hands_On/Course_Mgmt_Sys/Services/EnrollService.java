package com.Hands_On.Course_Mgmt_Sys.Services;

import com.Hands_On.Course_Mgmt_Sys.Enums.Role;
import com.Hands_On.Course_Mgmt_Sys.Models.Course;
import com.Hands_On.Course_Mgmt_Sys.Models.Enroll;
import com.Hands_On.Course_Mgmt_Sys.Models.Student;
import com.Hands_On.Course_Mgmt_Sys.Models.User;
import com.Hands_On.Course_Mgmt_Sys.Repositories.CourseRepository;
import com.Hands_On.Course_Mgmt_Sys.Repositories.EnrollmentRepository;
import com.Hands_On.Course_Mgmt_Sys.Repositories.UserRepository;
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
