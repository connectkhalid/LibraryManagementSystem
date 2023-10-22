package com.khalid.onlinebooklibraryapplication.controller;


import com.khalid.onlinebooklibraryapplication.constants.AppConstants;
import com.khalid.onlinebooklibraryapplication.dto.UserDto;
import com.khalid.onlinebooklibraryapplication.dto.UserLoginRequestModel;
import com.khalid.onlinebooklibraryapplication.dto.UserRequestDto;
import com.khalid.onlinebooklibraryapplication.service.implementation.UserServiceImplementation;
import com.khalid.onlinebooklibraryapplication.utils.JWTUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserServiceImplementation userServiceImplementation;
    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/users/{userId}")
    public ResponseEntity<?> userDetailsByUserId(@PathVariable Long userId) {
        try {
            UserDto user = userServiceImplementation.getUserByUserId(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user/register")
    public ResponseEntity<?> register (@RequestBody UserRequestDto userRequestDto) {
        try {
            UserDto createdUser = userServiceImplementation.createUser(userRequestDto);
            String accessToken = JWTUtils.generateToken(createdUser.getEmail());
            Map<String, Object> registerResponse = new HashMap<>();
            registerResponse.put("user", createdUser);
            registerResponse.put(AppConstants.HEADER_STRING, AppConstants.TOKEN_PREFIX + accessToken);
            return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequestModel userLoginReqModel, HttpServletResponse response) {
        try {
            System.out.println(userLoginReqModel.getEmail());
            System.out.println(userLoginReqModel.getPassword());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginReqModel.getEmail(), userLoginReqModel.getPassword()));
            UserDto userDto = userServiceImplementation.getUser(userLoginReqModel.getEmail());
            String accessToken = JWTUtils.generateToken(userDto.getEmail());
            Map<String, Object> loginResponse = new HashMap<>();
            loginResponse.put("userId", userDto.getUserId());
            loginResponse.put("email", userDto.getEmail());
            loginResponse.put(AppConstants.HEADER_STRING, AppConstants.TOKEN_PREFIX + accessToken);
            return ResponseEntity.status(HttpStatus.OK).body(loginResponse);

        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Wrong password!", HttpStatus.UNAUTHORIZED);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Wrong Email!", HttpStatus.UNAUTHORIZED);

        }
    }
}
