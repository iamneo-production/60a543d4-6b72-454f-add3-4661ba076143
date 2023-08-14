package com.lcwd.appointment.service.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.appointment.service.entities.Appointment;


//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.lcwd.appointment.service.entities.Appointment;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByAppointmentDateTimeAfter(LocalDateTime now);
}


















//public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
//
//}
