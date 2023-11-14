package edu.disease.asn6;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class PatientZeroTest {

    @Test
    void testGetSetPatient() {
        // Arrange
        PatientZero patientZero = new PatientZero();
        Patient patient = new Patient(3, 2);
        patient.setPatientId(UUID.randomUUID());

        // Act
        patientZero.setPatient(patient);

        // Assert
        assertEquals(patient, patientZero.getPatient());
    }

    @Test
    void testGetSetExposureDateTime() {
        // Arrange
        PatientZero patientZero = new PatientZero();
        LocalDateTime exposureDateTime = LocalDateTime.now();

        // Act
        patientZero.setExposureDateTime(exposureDateTime);

        // Assert
        assertEquals(exposureDateTime, patientZero.getExposureDateTime());
    }

    @Test
    void testIsSetExposed() {
        // Arrange
        PatientZero patientZero = new PatientZero();

        // Act
        patientZero.setExposed(true);

        // Assert
        assertTrue(patientZero.isExposed());
    }
}
