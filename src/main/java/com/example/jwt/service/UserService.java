package com.example.jwt.service;

import com.example.jwt.dto.UserDto;

public interface UserService {
    public UserDto createUser(UserDto userDto);
}