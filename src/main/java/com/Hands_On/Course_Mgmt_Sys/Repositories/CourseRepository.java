package com.Hands_On.Course_Mgmt_Sys.Repositories;

import com.Hands_On.Course_Mgmt_Sys.Models.Course;
import com.Hands_On.Course_Mgmt_Sys.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
