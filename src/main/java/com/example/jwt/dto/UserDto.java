package com.example.jwt.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private Long id;

    private String name;

    private String email;

    private String password;
}
