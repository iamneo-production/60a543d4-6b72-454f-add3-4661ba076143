package com.remainder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.remainder.entities.CommunicationPreference;

@FeignClient(name = "communication-service")
public interface CommunicationClient {
    @GetMapping("/communication/preferences/{patientId}")
    CommunicationPreference getCommunicationPreference(@PathVariable("patientId") Long patientId);
}
