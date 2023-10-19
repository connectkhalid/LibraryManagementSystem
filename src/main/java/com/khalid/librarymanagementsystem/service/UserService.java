package com.khalid.librarymanagementsystem.service;

import com.khalid.librarymanagementsystem.dto.LoginRequest;
import com.khalid.librarymanagementsystem.dto.LoginResponse;
import com.khalid.librarymanagementsystem.dto.RegisterRequest;
import com.khalid.librarymanagementsystem.dto.RegisterResponse;

public interface UserService {
    public RegisterResponse registerUser(RegisterRequest registerRequest);
    public LoginResponse loginUser(LoginRequest loginRequest);
}
