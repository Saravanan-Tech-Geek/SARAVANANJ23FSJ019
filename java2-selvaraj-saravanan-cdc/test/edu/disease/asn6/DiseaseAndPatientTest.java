package edu.disease.asn6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiseaseAndPatientTest {

    private DiseaseAndPatient diseaseAndPatient;

    @BeforeEach
    void setUp() {
        Disease[] diseases = {new InfectiousDisease(), new NonInfectiousDisease()};
        Patient[] patients = {new Patient(3, 5), new Patient(2, 4)};
        diseaseAndPatient = new DiseaseAndPatient(diseases, patients);
    }

    @Test
    void testGetDiseases() {
        List<Disease> actualDiseases = diseaseAndPatient.getDiseases();
        assertNotNull(actualDiseases);
        assertEquals(2, actualDiseases.size());
        assertTrue(actualDiseases.get(0) instanceof InfectiousDisease);
        assertTrue(actualDiseases.get(1) instanceof NonInfectiousDisease);
    }

    @Test
    void testSetDiseases() {
        Disease[] newDiseases = {new InfectiousDisease(), new NonInfectiousDisease()};
        diseaseAndPatient.setDiseases(newDiseases);

        List<Disease> actualDiseases = diseaseAndPatient.getDiseases();
        assertNotNull(actualDiseases);
        assertEquals(2, actualDiseases.size());
        assertTrue(actualDiseases.get(0) instanceof InfectiousDisease);
        assertTrue(actualDiseases.get(1) instanceof NonInfectiousDisease);
    }

    @Test
    void testGetPatients() {
        List<Patient> actualPatients = diseaseAndPatient.getPatients();
        assertNotNull(actualPatients);
        assertEquals(2, actualPatients.size());
    }

    @Test
    void testSetPatients() {
        Patient[] newPatients = {new Patient(4, 6), new Patient(1, 3)};
        diseaseAndPatient.setPatients(newPatients);

        List<Patient> actualPatients = diseaseAndPatient.getPatients();
        assertNotNull(actualPatients);
        assertEquals(2, actualPatients.size());
    }
}
