package com.Hands_On.Course_Mgmt_Sys.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int course_id;

    @Column(name = "title")
    private String course_name;

    @Column(name = "description")
    private String course_description;

    @ManyToOne
    private User Instructor;
}
