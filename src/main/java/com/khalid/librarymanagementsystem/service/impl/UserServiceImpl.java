package com.khalid.librarymanagementsystem.service.impl;

import com.khalid.librarymanagementsystem.dto.LoginRequest;
import com.khalid.librarymanagementsystem.dto.LoginResponse;
import com.khalid.librarymanagementsystem.dto.RegisterRequest;
import com.khalid.librarymanagementsystem.dto.RegisterResponse;
import com.khalid.librarymanagementsystem.repository.UserRepository;
import com.khalid.librarymanagementsystem.security.JwtService;
import com.khalid.librarymanagementsystem.service.RoleService;
import com.khalid.librarymanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        return null;
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {

//        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
//                loginRequest.getEmail(),
//                loginRequest.getPassword()
//        ));

        String jwtToken = jwtService.generateToken(userDetailsService.loadUserByUsername(loginRequest.getEmail()));

        return LoginResponse.builder()
                .token(jwtToken)
                .build();

    }
}
