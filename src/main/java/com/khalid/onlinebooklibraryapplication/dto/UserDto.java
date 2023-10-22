package com.khalid.onlinebooklibraryapplication.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private long userId;
    @NonNull
    private String firstName;
    private String lastName;
    private String address;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String role;

    public void setAccessToken(String s) {
    }
}
