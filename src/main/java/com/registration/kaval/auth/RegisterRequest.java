package com.registration.kaval.auth;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String surname;
    private String email;
    private String password;

    private String phoneNumber;

    private int age;
}