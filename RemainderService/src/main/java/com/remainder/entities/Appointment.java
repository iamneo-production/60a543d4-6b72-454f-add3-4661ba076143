package com.remainder.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private LocalDateTime appointmentDateTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public LocalDateTime getAppointmentDateTime() {
		return appointmentDateTime;
	}
	public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}

}



























//import java.time.LocalDateTime;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
//
//@Entity
//public class Appointment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//   
//   private LocalDateTime appointmentDate;
//   @OneToOne(cascade = CascadeType.ALL)
//   private Patient patient;
//   @OneToOne(cascade = CascadeType.ALL)
//   private Doctor doctor;
//   @OneToOne(cascade = CascadeType.ALL)
//   private AppointmentType appointmentType;
// 
//public Long getId() {
//	return id;
//}
//public void setId(Long id) {
//	this.id = id;
//}
//public LocalDateTime getAppointmentDate() {
//	return appointmentDate;
//}
//public void setAppointmentDate(LocalDateTime appointmentDate) {
//	this.appointmentDate = appointmentDate;
//}
//public Patient getPatient() {
//	return patient;
//}
//public void setPatient(Patient patient) {
//	this.patient = patient;
//}
//public Doctor getDoctor() {
//	return doctor;
//}
//public void setDoctor(Doctor doctor) {
//	this.doctor = doctor;
//}
//
//public AppointmentType getAppointmentType() {
//	return appointmentType;
//}
//public void setAppointmentType(AppointmentType appointmentType) {
//	this.appointmentType = appointmentType;
//}
//
//	
//	
//   
//	
//   
//	
//}