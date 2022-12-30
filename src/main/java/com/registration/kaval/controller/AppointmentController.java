package com.registration.kaval.controller;

import com.registration.kaval.dto.AppointmentDto;
import com.registration.kaval.service.serviceImpl.AppointmentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
public class  AppointmentController {

    private final AppointmentServiceImpl appointmentService;

    public AppointmentController(AppointmentServiceImpl appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity saveAppointment(@RequestBody AppointmentDto appointmentDto){
        appointmentService.saveAppointment(appointmentDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> findAllAppointment(){
        return ResponseEntity.ok(appointmentService.findAllAppointments());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AppointmentDto> cancelAppointment(@PathVariable Long id, @RequestBody AppointmentDto appointmentDto) {
        appointmentService.cancelAppointment(id, appointmentDto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/date/{id}")
    public ResponseEntity<AppointmentDto> changeAppointmentDate(@PathVariable Long id, @RequestBody AppointmentDto appointmentDto) {
        appointmentService.changeAppointmentDate(id, appointmentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/testing/{id}")
    public ResponseEntity<AppointmentDto> testing(@PathVariable Long id, @RequestBody AppointmentDto appointmentDto) {
        appointmentService.updateAppointment(id, appointmentDto);
        return ResponseEntity.ok().build();
    }
}
