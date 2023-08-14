package com.lcwd.communication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.communication.entities.CommunicationPreference;
import com.lcwd.communication.service.CommunicationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/communication")
public class CommunicationController {
    @Autowired
    private CommunicationService communicationService;

    @GetMapping("/preferences/{patientId}")
    public ResponseEntity<CommunicationPreference> getCommunicationPreference(@PathVariable Long patientId) {
        CommunicationPreference preference = communicationService.getCommunicationPreference(patientId);
        if (preference != null) {
            return ResponseEntity.ok(preference);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/preferences/{patientId}")
    public ResponseEntity<String> updateCommunicationPreference(
            @PathVariable Long patientId, @RequestBody CommunicationPreference newPreference) {
        CommunicationPreference updatedPreference = communicationService.updateCommunicationPreference(patientId, newPreference);
        if (updatedPreference != null) {
            return ResponseEntity.ok("Communication preference updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
}
}

