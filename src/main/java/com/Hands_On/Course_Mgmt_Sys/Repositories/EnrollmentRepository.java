package com.Hands_On.Course_Mgmt_Sys.Repositories;

import com.Hands_On.Course_Mgmt_Sys.Models.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enroll,Long> {

}
