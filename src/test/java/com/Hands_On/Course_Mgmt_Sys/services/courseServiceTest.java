package com.Hands_On.Course_Mgmt_Sys.services;

import com.Hands_On.Course_Mgmt_Sys.enums.Role;
import com.Hands_On.Course_Mgmt_Sys.models.Course;
import com.Hands_On.Course_Mgmt_Sys.models.User;
import com.Hands_On.Course_Mgmt_Sys.repositories.CourseRepository;
import com.Hands_On.Course_Mgmt_Sys.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;



import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CourseService courseService;

    private User instructor;
    private Course course;

    @BeforeEach
    void setUp() {
        instructor = new User();
        instructor.setId(1L);
        instructor.setRole(Role.INSTRUCTOR);

        course = new Course();
        course.setCourse_id(101);
        course.setCourse_name("Spring Boot Fundamentals");
        course.setCourse_description("Learn to build Spring Boot apps easily");
    }

    @Test
    void createCourse_ShouldSaveCourse_WhenInstructorOrAdmin() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(instructor));
        when(courseRepository.save(any(Course.class))).thenReturn(course);

        Course saved = courseService.createCourse(1L, course);

        assertThat(saved).isNotNull();
        verify(courseRepository, times(1)).save(course);
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void createCourse_ShouldThrowError_WhenUserIsNotInstructorOrAdmin() {
        User student = new User();
        student.setId(2L);
        student.setRole(Role.STUDENT);

        when(userRepository.findById(2L)).thenReturn(Optional.of(student));

        assertThatThrownBy(() -> courseService.createCourse(2L, course))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Only instructors or admins can create courses");

        verify(courseRepository, never()).save(any());
    }

    @Test
    void createCourse_ShouldThrowError_WhenInstructorNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> courseService.createCourse(1L, course))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Instructor not found");
    }

    @Test
    void getAllCourses_ShouldReturnAllCourses() {
        when(courseRepository.findAll()).thenReturn(List.of(course));

        List<Course> result = courseService.getAllCourses();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getCourse_name()).isEqualTo("Spring Boot Fundamentals");
        verify(courseRepository, times(1)).findAll();
    }
}
