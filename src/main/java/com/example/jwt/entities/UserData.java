package com.example.jwt.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USER_DATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String roles;

    private boolean isEnabled;
}
