package com.khalid.librarymanagementsystem.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class RegisterRequest {
    @NotEmpty(message = "firstName is required")
    private String firstName;
    @NotEmpty(message = "lastName is required")
    private String lastName;
    @NotEmpty(message = "email is required")
    private String email;
    @NotEmpty(message = "password is required")
    private String password;
    @NotEmpty(message = "address is required")
    private String  address;
    @NotEmpty(message = "roles is required")
    private List<String> roles;
}
