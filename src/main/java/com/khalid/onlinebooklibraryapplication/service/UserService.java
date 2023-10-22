package com.khalid.onlinebooklibraryapplication.service;

import com.khalid.onlinebooklibraryapplication.dto.UserDto;
import com.khalid.onlinebooklibraryapplication.dto.UserRequestDto;

public interface UserService {
    UserDto createUser(UserRequestDto userRequestDto) throws Exception;
    UserDto getUser(String email);
    UserDto getUserByUserId(Long id) throws Exception;
}
