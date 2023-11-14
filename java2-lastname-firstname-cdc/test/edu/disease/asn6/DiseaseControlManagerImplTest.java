package edu.disease.asn6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.disease.asn1.constants.ExposureConstants;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DiseaseControlManagerImplTest {

    private DiseaseControlManager diseaseControlManager;

    @BeforeEach
    void setUp() {
        diseaseControlManager = new DiseaseControlManagerImpl(5, 10);
    }

    @Test
    void testAddDisease() {
        Disease disease = diseaseControlManager.addDisease("Test Disease", true);
        assertNotNull(disease);
        assertEquals("Test Disease", disease.getName());
        assertNotNull(disease.getDiseaseId());
        assertTrue(disease instanceof InfectiousDisease);
    }

    @Test
    void testGetDisease() {
        Disease addedDisease = diseaseControlManager.addDisease("Test Disease", true);
        UUID diseaseId = addedDisease.getDiseaseId();
        Disease retrievedDisease = diseaseControlManager.getDisease(diseaseId);

        assertNotNull(retrievedDisease);
        assertEquals(addedDisease, retrievedDisease);
    }

    @Test
    void testAddPatient() {
        Patient patient = diseaseControlManager.addPatient("John", "Doe", 3, 5);
        assertNotNull(patient);
        assertEquals("John", patient.getFirstName());
        assertEquals("Doe", patient.getLastName());
        assertNotNull(patient.getPatientId());
    }

    @Test
    void testGetPatient() {
        Patient addedPatient = diseaseControlManager.addPatient("John", "Doe", 3, 5);
        UUID patientId = addedPatient.getPatientId();
        Patient retrievedPatient = diseaseControlManager.getPatient(patientId);

        assertNotNull(retrievedPatient);
        assertEquals(addedPatient, retrievedPatient);
    }

    @Test
    void testAddDiseaseToPatient() {
        Disease addedDisease = diseaseControlManager.addDisease("Test Disease", true);
        Patient patient = diseaseControlManager.addPatient("John", "Doe", 3, 5);

        diseaseControlManager.addDiseaseToPatient(patient.getPatientId(), addedDisease.getDiseaseId());

        assertTrue(patient.hasDisease(addedDisease.getDiseaseId()));
    }

    @Test
    void testAddExposureToPatient() {
        Patient patient = diseaseControlManager.addPatient("John", "Doe", 3, 5);
        Exposure exposure = new Exposure(LocalDateTime.now(),UUID.randomUUID(),ExposureConstants.DIRECT_EXPOSURE);

        diseaseControlManager.addExposureToPatient(patient.getPatientId(), exposure);

        assertTrue(patient.hasExposure(exposure));
    }
}
