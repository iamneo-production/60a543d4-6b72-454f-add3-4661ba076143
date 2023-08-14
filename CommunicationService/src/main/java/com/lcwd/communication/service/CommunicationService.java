package com.lcwd.communication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.communication.PatientClient;
import com.lcwd.communication.ReminderClient;
import com.lcwd.communication.entities.CommunicationPreference;
import com.lcwd.communication.entities.Patient;
import com.lcwd.communication.repository.CommunicationPreferenceRepository;

@Service
public class CommunicationService {
    @Autowired
    private CommunicationPreferenceRepository communicationPreferenceRepository;
    
    @Autowired
    private PatientClient patientClient;
    
    @Autowired
    private ReminderClient reminderClient;

    public CommunicationPreference getCommunicationPreference(Long patientId) {
        return communicationPreferenceRepository.findByPatientId(patientId);
    }
    
    public CommunicationPreference updateCommunicationPreference(Long patientId, CommunicationPreference newPreference) {
        CommunicationPreference existingPreference = communicationPreferenceRepository.findByPatientId(patientId);
        if (existingPreference != null) {
            existingPreference.setPreferredMethod(newPreference.getPreferredMethod());
            communicationPreferenceRepository.save(existingPreference);
            return existingPreference;
        }
        return null; // Communication preference not found
    }
    
    public String sendReminder(Long patientId) {
        Patient patient = patientClient.getPatientById(patientId);
        if (patient != null) {
            // Fetch communication preference from this service
            CommunicationPreference preference = getCommunicationPreference(patient.getId());

            if (preference != null) {
                if ("sms".equals(preference.getPreferredMethod())) {
                    // Call Reminder Service to send SMS reminder
                    reminderClient.sendSMSReminder(patient.getContactInfo());
                    return "SMS reminder sent";
                } else if ("email".equals(preference.getPreferredMethod())) {
                    // Call Reminder Service to send email reminder
                    reminderClient.sendEmailReminder(patient.getContactInfo());
                    return "Email reminder sent";
                }
            }
        }
        return "Reminder not sent";
}
}
