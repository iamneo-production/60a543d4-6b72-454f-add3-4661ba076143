package com.remainder;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.remainder.entities.Appointment;

@FeignClient(name = "appointment-service")
public interface AppointmentClient {
    @GetMapping("/appointments/upcoming")
    List<Appointment> getUpcomingAppointments();
}
