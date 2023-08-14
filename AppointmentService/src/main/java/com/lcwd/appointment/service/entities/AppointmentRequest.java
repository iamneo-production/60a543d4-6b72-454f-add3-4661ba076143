//package com.lcwd.appointment.service.entities;
//
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class AppointmentRequest {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Long patientId;
//    private Long doctorId;
//    private LocalDateTime requestedDate;
//    private String notes;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "status_id")
//    private AppointmentStatus status;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Long getPatientId() {
//		return patientId;
//	}
//
//	public void setPatientId(Long patientId) {
//		this.patientId = patientId;
//	}
//
//	public Long getDoctorId() {
//		return doctorId;
//	}
//
//	public void setDoctorId(Long doctorId) {
//		this.doctorId = doctorId;
//	}
//
//	public LocalDateTime getRequestedDate() {
//		return requestedDate;
//	}
//
//	public void setRequestedDate(LocalDateTime requestedDate) {
//		this.requestedDate = requestedDate;
//	}
//
//	public String getNotes() {
//		return notes;
//	}
//
//	public void setNotes(String notes) {
//		this.notes = notes;
//	}
//
//	public AppointmentStatus getStatus() {
//		return status;
//	}
//
//	public void setStatus(AppointmentStatus status) {
//		this.status = status;
//	}
//
//    
//    // Getters and setters
//}