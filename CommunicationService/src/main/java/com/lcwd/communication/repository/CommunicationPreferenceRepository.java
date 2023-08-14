package com.lcwd.communication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.communication.entities.CommunicationPreference;

@Repository
public interface CommunicationPreferenceRepository extends JpaRepository<CommunicationPreference, Long> {
    CommunicationPreference findByPatientId(Long patientId);
}