package com.lcwd.appointment.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.appointment.service.Services.AppointmentService;
import com.lcwd.appointment.service.entities.Appointment;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<String> createAppointment(@RequestBody Appointment appointment) {
        appointmentService.createAppointment(appointment);
        return ResponseEntity.ok("Appointment created successfully");
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<Appointment>> getUpcomingAppointments() {
        List<Appointment> upcomingAppointments = appointmentService.getUpcomingAppointments();
        return ResponseEntity.ok(upcomingAppointments);
    }
}


























//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.lcwd.appointment.service.Services.AppointmentService;
//import com.lcwd.appointment.service.Services.AppointmentServiceImpl;
//import com.lcwd.appointment.service.entities.Appointment;
//
//@RestController
//public class AppointmentController {
//	
//	@Autowired
//	private AppointmentService appointmentService;
//	
//	@PostMapping("/appointment")
//	public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment){
//	Appointment appointment1=appointmentService.saveAppointment(appointment);
//	return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
//	
//}

