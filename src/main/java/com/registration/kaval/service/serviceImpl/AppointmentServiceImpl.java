package com.registration.kaval.service.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.registration.kaval.model.User;
import com.registration.kaval.dto.AppointmentDto;
import com.registration.kaval.model.Appointment;
import com.registration.kaval.repository.AppointmentRepository;
import com.registration.kaval.repository.UserRepository;
import com.registration.kaval.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    private UserRepository userRepository;

    private ModelMapper mapper = new ModelMapper();

    private ObjectMapper objectMapper = new ObjectMapper();

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveAppointment(AppointmentDto appointmentDto) {
        Optional<User> user = userRepository.findByEmail(appointmentDto.getUserEmail());
        if (user.isPresent()) {
            Appointment appointment = mapper.map(appointmentDto, Appointment.class);
            appointment.setUser(user.get());
            appointmentRepository.save(appointment);
        }
    }

    @Override
    public List<AppointmentDto> findAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map((appointment -> mapper.map(appointment, AppointmentDto.class)))
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDto cancelAppointment(Long id, AppointmentDto appointmentDto) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        appointment.setCanceled(appointmentDto.isCanceled());
        appointmentRepository.save(appointment);
        return appointmentDto;
    }

    @Override
    public AppointmentDto changeAppointmentDate(Long id, AppointmentDto appointmentDto) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        appointment.setDate(appointmentDto.getDate());
        appointment.setTime(appointmentDto.getTime());
        appointmentRepository.save(appointment);
        return mapper.map(appointment, AppointmentDto.class);
    }

    @Override
    public void deleteAppointment(Long id) {
            appointmentRepository.deleteById(id);
    }

    public AppointmentDto updateAppointment(Long id, AppointmentDto appointmentDto) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (Objects.nonNull(appointment)) {
            appointment = objectMapper.convertValue(appointmentDto, Appointment.class);
            appointmentRepository.save(appointment);
        }
        return mapper.map(appointment, AppointmentDto.class);
    }
}
