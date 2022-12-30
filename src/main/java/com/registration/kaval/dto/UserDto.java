package com.registration.kaval.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class UserDto {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private int age;
    private String password;
    private List<AppointmentDto> appointments;

}
