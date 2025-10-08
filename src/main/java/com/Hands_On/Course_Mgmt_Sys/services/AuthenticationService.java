package com.Hands_On.Course_Mgmt_Sys.services;

import com.Hands_On.Course_Mgmt_Sys.dto.LoginReq;
import com.Hands_On.Course_Mgmt_Sys.models.User;
import com.Hands_On.Course_Mgmt_Sys.repositories.UserRepository;
import com.Hands_On.Course_Mgmt_Sys.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User signup(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String login(LoginReq loginReq) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginReq.getUsername(),
                        loginReq.getPassword()
                )
        );

        if (authentication.isAuthenticated()) {
            return jwtUtil.generateToken(loginReq.getUsername());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}

