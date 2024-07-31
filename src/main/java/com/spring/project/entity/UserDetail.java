package com.spring.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
}
