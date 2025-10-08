package com.Hands_On.Course_Mgmt_Sys.repositories;

import com.Hands_On.Course_Mgmt_Sys.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
