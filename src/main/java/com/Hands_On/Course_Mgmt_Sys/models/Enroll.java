package com.Hands_On.Course_Mgmt_Sys.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrol_id;

    @ManyToOne
    private User Student;

    @ManyToOne
    private Course Course;

}
