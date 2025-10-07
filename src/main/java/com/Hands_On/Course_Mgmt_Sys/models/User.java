package com.Hands_On.Course_Mgmt_Sys.models;

import com.Hands_On.Course_Mgmt_Sys.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(unique = true)
        private String username;
        private String password;

        @Enumerated(EnumType.STRING)
        private Role role; // STUDENT, INSTRUCTOR, ADMIN
}