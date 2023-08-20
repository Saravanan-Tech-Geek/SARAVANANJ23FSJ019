package edu.disease.asn2;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.disease.asn1.Exposure;
import edu.disease.asn1.constants.ExposureConstants;
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

	@Test
	void testCompareToWithLastNameToNull() {
		Patient patient1 = new Patient(3, 2);
		patient1.setPatientId(UUID.randomUUID());
		patient1.setFirstName("Jane");

		Patient patient2 = new Patient(3, 2);
		patient2.setPatientId(UUID.randomUUID());
		patient2.setFirstName("John");

		assertTrue(patient1.compareTo(patient2) == 0);
	}

	@Test
	void testCompareToWithFirstNameToNull() {
		Patient patient1 = new Patient(3, 2);
		patient1.setPatientId(UUID.randomUUID());
		patient1.setLastName("Doe");

		Patient patient2 = new Patient(3, 2);
		patient2.setPatientId(UUID.randomUUID());
		patient2.setLastName("Doe");

		assertTrue(patient1.compareTo(patient2) == 0);
	}

	@Test
	void testCompareToWithSecondObjectFirstNameToNull() {
		Patient patient1 = new Patient(3, 2);
		patient1.setPatientId(UUID.randomUUID());
		patient1.setFirstName("John");
		patient1.setLastName("Doe");

		Patient patient2 = new Patient(3, 2);
		patient2.setPatientId(UUID.randomUUID());
		patient2.setLastName("Doe");
		assertTrue(patient1.compareTo(patient2) == 1);
	}

	@Test
	void testCompareToWithFirstName() {
		Patient patient1 = new Patient(3, 2);
		patient1.setPatientId(UUID.randomUUID());
		patient1.setFirstName("Jane");
		patient1.setLastName("Doe");

		Patient patient2 = new Patient(3, 2);
		patient2.setPatientId(UUID.randomUUID());
		patient2.setFirstName("John");
		patient2.setLastName("Doe");
		assertTrue(patient1.compareTo(patient2) < 0);
	}

	@Test
	public void testGetFirstName() {
		Patient patient = new Patient(3, 2);
		patient.setFirstName("John");
		assertEquals("John", patient.getFirstName());
	}

	@Test
	public void testSetFirstName() {
		Patient patient = new Patient(3, 2);
		patient.setFirstName("Alice");
		assertEquals("Alice", patient.getFirstName());
	}

	@Test
	public void testGetLastName() {
		Patient patient = new Patient(3, 2);
		patient.setLastName("Doe");
		assertEquals("Doe", patient.getLastName());
	}

	@Test
	public void testSetLastName() {
		Patient patient = new Patient(3, 2);
		patient.setLastName("Sam");
		assertEquals("Sam", patient.getLastName());
	}

	@Test
	public void testToString() {
		Patient patient = new Patient(3, 2);
		patient.setPatientId(UUID.randomUUID());
		patient.setFirstName("John");
		patient.setLastName("Doe");

		String expected = "Patient [patientId=" + patient.getPatientId()
				+ ", firstName=John, lastName=Doe, exposures=[null, null], diseaseIds=[null, null, null]]";

		assertEquals(expected, patient.toString());
	}

	@Test
	public void testEqualsAndHashMethod() {
		UUID patientId1 = UUID.randomUUID();
		UUID patientId2 = UUID.randomUUID();

		Patient patient1a = new Patient(3, 2);
		patient1a.setPatientId(patientId1);

		Patient patient1b = new Patient(3, 2);
		patient1b.setPatientId(patientId1);

		Patient patient2 = new Patient(4, 6);
		patient2.setPatientId(patientId2);

		assertTrue(patient1a.equals(patient1a));
		assertTrue(patient1a.equals(patient1b));
		assertTrue(patient1b.equals(patient1a));
		assertFalse(patient1a.equals(patient2));

		assertEquals(patient1a.hashCode(), patient1b.hashCode());
	}

	@Test
	public void testHasExposures() {
		LocalDateTime dateTime = LocalDateTime.now();
		UUID patientId = UUID.randomUUID();
		String exposureType = ExposureConstants.DIRECT_EXPOSURE;
		Exposure exposure = new Exposure(dateTime, patientId, exposureType);
		patient.addExposure(exposure);

		patient.getExposures();

		boolean result = patient.hasExposure(exposure);

		assertTrue(result);
	}

	@Test
	public void testHasNoMatchingExposures() {
		patient.addExposure(null);

		boolean result = patient.hasExposure(null);

		assertEquals(false, result);
	}

	@Test
	public void testHasDiseaseMethod() {
		UUID diseaseId = UUID.randomUUID();
		patient.addDiseaseId(diseaseId);
		boolean result = patient.hasDisease(diseaseId);
		assertEquals(true, result);
	}

}
