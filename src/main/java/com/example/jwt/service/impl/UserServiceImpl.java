package com.example.jwt.service.impl;

import com.example.jwt.dto.UserDto;
import com.example.jwt.entities.UserData;
import com.example.jwt.repository.UserRepository;
import com.example.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserData user = convertToEntity(userDto);
        return convertToDto(userRepository.save(user));
    }

    private UserData convertToEntity(UserDto userDto) {
        return UserData.builder()
                .name(userDto.getName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .roles("ROLE_USER")
                .isEnabled(true)
                .build();

    }

    private UserDto convertToDto(UserData user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();

    }
}
