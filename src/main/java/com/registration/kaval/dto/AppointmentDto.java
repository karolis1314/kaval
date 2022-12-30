package com.registration.kaval.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;

@Data
@Component
public class AppointmentDto {

    private String userEmail;
    private Date date;

    private Time time;
    private String notes;
    private boolean canceled;
}
