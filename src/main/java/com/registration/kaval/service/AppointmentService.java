package com.registration.kaval.service;

import com.registration.kaval.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {

    void saveAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> findAllAppointments();

    AppointmentDto cancelAppointment(Long id, AppointmentDto appointmentDto);

    AppointmentDto changeAppointmentDate(Long id, AppointmentDto appointmentDto);

    void deleteAppointment(Long id);
}
