package com.remainder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.remainder.AppointmentClient;
import com.remainder.CommunicationClient;
import com.remainder.NotificationClient;
import com.remainder.PatientClient;
import com.remainder.entities.Appointment;
import com.remainder.entities.CommunicationPreference;
import com.remainder.entities.Patient;

@RestController
public class ReminderController {
    @Autowired
    private AppointmentClient appointmentClient;

    @Autowired
    private PatientClient patientClient;

    @Autowired
    private CommunicationClient communicationClient;

    @Autowired
    private NotificationClient notificationClient;

    @Scheduled(fixedDelay = 60000) // Every 1 minute for example
    public void sendReminders() {
        List<Appointment> upcomingAppointments = appointmentClient.getUpcomingAppointments();

        for (Appointment appointment : upcomingAppointments) {
            Patient patient = patientClient.getPatientById(appointment.getPatientId());
            CommunicationPreference preference = communicationClient.getCommunicationPreference(patient.getId());

            if (preference == null) {
                // Send default reminder
                notificationClient.sendDefaultReminder(patient.getContactInfo());
            } else {
                if ("sms".equals(preference.getPreferredMethod())) {
                    notificationClient.sendSMSReminder(patient.getContactInfo());
                } else if ("email".equals(preference.getPreferredMethod())) {
                    notificationClient.sendEmailReminder(patient.getContactInfo());
                }
            }

            // Update reminder status in Reminder Service
            // ...
        }
    }
}

