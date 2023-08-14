package com.remainder.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remainder.CommunicationClient;
import com.remainder.PatientClient;
import com.remainder.entities.CommunicationPreference;
import com.remainder.entities.Patient;
import com.remainder.entities.Reminder;
import com.remainder.repository.ReminderRepository;

@Service
public class ReminderService {
    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private PatientClient patientClient; // Feign client for Patient Service

    @Autowired
    private CommunicationClient communicationClient; // Feign client for Communication Service

    public void sendReminders() {
        LocalDateTime now = LocalDateTime.now();
        List<Reminder> remindersToSend = reminderRepository.findByReminderDateTimeBefore(now);

        for (Reminder reminder : remindersToSend) {
            Patient patient = patientClient.getPatientById(reminder.getPatientId());
            if (patient != null) {
                CommunicationPreference preference = communicationClient.getCommunicationPreference(patient.getId());
                if (preference != null) {
                    if ("sms".equals(preference.getPreferredMethod())) {
                        sendSMSReminder(patient.getContactInfo());
                    } else if ("email".equals(preference.getPreferredMethod())) {
                        sendEmailReminder(patient.getContactInfo());
                    }
                }
            }
            // Mark reminder as sent in the database
           // reminder.setSent(true);
            reminderRepository.save(reminder);
        }
    }

    private void sendSMSReminder(String contactInfo) {
        // Code to send SMS reminder
    }

    private void sendEmailReminder(String contactInfo) {
        // Code to send email reminder
    }
}
