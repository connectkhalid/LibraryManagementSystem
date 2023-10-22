package com.khalid.onlinebooklibraryapplication.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String address;
    @NonNull
    private String email;
    @NonNull
    private String password;
    public void setAccessToken(String s) {
    }
}
