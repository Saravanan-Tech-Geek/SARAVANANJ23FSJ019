package edu.disease.asn2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.disease.asn1.Exposure;
import exception.UnknownExposureTypeException;

class PatientTest {

	private Patient patient;

	@BeforeEach
	void setUp() {
		patient = new Patient(3, 2); // Max diseases: 3, Max exposures: 2
		patient.setPatientId(UUID.randomUUID());
		patient.setFirstName("John");
		patient.setLastName("Doe");
	}
	
	@Test
	public void testPatientConstructor() {
		int maxDiseases = 3;
		int maxExposures = 2;

		Patient patientObj = new Patient(maxDiseases, maxExposures);

		assertEquals(maxDiseases, patientObj.getDiseaseIds().length);
		assertEquals(maxExposures, patientObj.getExposures().length);
	}

	@Test
	public void testPatientConstructorWithNegativeValue() {
		int maxDiseases = 0;
		int maxExposures = -1;
		assertThrows(UnknownExposureTypeException.class, () -> new Patient(maxDiseases, maxExposures));
	}

	@Test
	void testAddDiseaseId() {
		UUID diseaseId = UUID.randomUUID();
		patient.addDiseaseId(diseaseId);

		UUID[] diseaseIds = patient.getDiseaseIds();
		assertEquals(diseaseId, diseaseIds[0]);
	}

	@Test
	void testAddDiseaseIdArrayFull() {
		// Fill up the disease IDs array
		for (int i = 0; i < 3; i++) {
			patient.addDiseaseId(UUID.randomUUID());
		}

		// Attempt to add one more disease ID should throw an exception
		assertThrows(IndexOutOfBoundsException.class, () -> patient.addDiseaseId(UUID.randomUUID()));
	}

	@Test
	void testAddExposure() {
		Exposure exposure = new Exposure(null, null, null);
		patient.addExposure(exposure);

		Exposure[] exposures = patient.getExposures();
		assertEquals(exposure, exposures[0]);
	}

	@Test
	void testAddExposureArrayFull() {
		// Fill up the exposures array
		for (int i = 0; i < 2; i++) {
			patient.addExposure(new Exposure(null, null, null));
		}

		// Attempt to add one more exposure should throw an exception
		assertThrows(IndexOutOfBoundsException.class, () -> patient.addExposure(new Exposure(null, null, null)));
	}

	@Test
	void testCompareTo() {
		Patient patient1 = new Patient(3, 2);
		patient1.setPatientId(UUID.randomUUID());
		patient1.setFirstName("Jane");
		patient1.setLastName("Dae");

		Patient patient2 = new Patient(3, 2);
		patient2.setPatientId(UUID.randomUUID());
		patient2.setFirstName("John");
		patient2.setLastName("Doe");

		assertTrue(patient1.compareTo(patient2) < 0);
	}
}
