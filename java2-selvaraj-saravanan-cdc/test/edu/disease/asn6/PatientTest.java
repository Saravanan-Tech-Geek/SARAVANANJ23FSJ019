package edu.disease.asn6;

import org.junit.jupiter.api.Test;

import edu.disease.asn1.constants.ExposureConstants;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

class PatientTest {

    @Test
    void testAddDiseaseId() {
        // Arrange
        Patient patient = new Patient(3, 2);
        UUID diseaseId = UUID.randomUUID();

        // Act
        patient.addDiseaseId(diseaseId);

        // Assert
        assertTrue(patient.getDiseaseIds().contains(diseaseId));
    }

    @Test
    void testAddExposure() {
        // Arrange
        Patient patient = new Patient(3, 2);
		Exposure exposure = new Exposure(null, UUID.randomUUID(), ExposureConstants.DIRECT_EXPOSURE);

        // Act
        patient.addExposure(exposure);

        // Assert
        assertTrue(patient.getExposures().contains(exposure));
    }

    @Test
    void testIsDiseaseIdsFull() {
        // Arrange
        Patient patient = new Patient(2, 2);
        UUID diseaseId1 = UUID.randomUUID();
        UUID diseaseId2 = UUID.randomUUID();

        // Act
        patient.addDiseaseId(diseaseId1);
        patient.addDiseaseId(diseaseId2);

        // Assert
        assertTrue(patient.isDiseaseIdsFull());
    }

    @Test
    void testIsExposureListFull() {
        // Arrange
        Patient patient = new Patient(3, 2);
        Exposure exposure1 = new Exposure(null, UUID.randomUUID(), ExposureConstants.DIRECT_EXPOSURE);
        Exposure exposure2 = new Exposure(null, UUID.randomUUID(), ExposureConstants.DIRECT_EXPOSURE);

        // Act
        patient.addExposure(exposure1);
        patient.addExposure(exposure2);

        // Assert
        assertTrue(patient.isExposureListFull());
    }

    @Test
    void testHasExposure() {
        // Arrange
        Patient patient = new Patient(3, 2);
        Exposure exposure = new Exposure(null, UUID.randomUUID(), ExposureConstants.DIRECT_EXPOSURE);

        // Act
        patient.addExposure(exposure);

        // Assert
        assertTrue(patient.hasExposure(exposure));
    }

    @Test
    void testHasDisease() {
        // Arrange
        Patient patient = new Patient(3, 2);
        UUID diseaseId = UUID.randomUUID();

        // Act
        patient.addDiseaseId(diseaseId);

        // Assert
        assertTrue(patient.hasDisease(diseaseId));
    }
}
