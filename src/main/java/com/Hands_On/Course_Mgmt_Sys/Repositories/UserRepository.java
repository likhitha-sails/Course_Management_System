package com.Hands_On.Course_Mgmt_Sys.Repositories;

import com.Hands_On.Course_Mgmt_Sys.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

