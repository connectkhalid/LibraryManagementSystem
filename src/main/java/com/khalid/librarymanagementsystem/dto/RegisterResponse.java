package com.khalid.librarymanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {
    private String id;
    private String email;
    private String message;
}
