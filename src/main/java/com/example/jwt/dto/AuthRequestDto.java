package com.example.jwt.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthRequestDto {
    private String email;

    private String password;
}
