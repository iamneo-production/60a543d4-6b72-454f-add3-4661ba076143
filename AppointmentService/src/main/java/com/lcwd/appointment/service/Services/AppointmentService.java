package com.lcwd.appointment.service.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.appointment.service.entities.Appointment;
import com.lcwd.appointment.service.repository.AppointmentRepository;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getUpcomingAppointments() {
        LocalDateTime now = LocalDateTime.now();
        return appointmentRepository.findByAppointmentDateTimeAfter(now);
    }

    public void createAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
