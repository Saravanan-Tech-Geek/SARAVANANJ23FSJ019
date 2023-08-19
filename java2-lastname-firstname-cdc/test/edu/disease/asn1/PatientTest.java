package edu.disease.asn1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.Test;

import edu.disease.asn1.constants.ExposureConstants;
import exception.UnknownExposureTypeException;

public class PatientTest {

	@Test
	public void testPatientConstructor() {
		int maxDiseases = 3;
		int maxExposures = 2;

		Patient patientObj = new Patient(maxDiseases, maxExposures);

		assertEquals(maxDiseases, patientObj.getDiseaseIds().length);
		assertEquals(maxExposures, patientObj.getExposures().length);
	}

	@Test(expected = UnknownExposureTypeException.class)
	public void testPatientConstructorWithNegativeValue() {
		int maxDiseases = 0;
		int maxExposures = -1;

		new Patient(maxDiseases, maxExposures);
	}

	@Test
	public void testAddDiseaseId() {
		int maxDiseases = 3;
		int maxExposures = 2;

		Patient patient = new Patient(maxDiseases, maxExposures);

		UUID dieaseId1 = UUID.randomUUID();
		UUID dieaseId2 = UUID.randomUUID();
		UUID dieaseId3 = UUID.randomUUID();

		patient.addDiseaseId(dieaseId1);
		patient.addDiseaseId(dieaseId2);
		patient.addDiseaseId(dieaseId3);

		UUID[] diseaseIds = patient.getDiseaseIds();

		assertEquals(dieaseId1, diseaseIds[0]);
		assertEquals(dieaseId2, diseaseIds[1]);
		assertEquals(dieaseId3, diseaseIds[2]);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundExceptionForAddDiseaseId() {
		int maxDiseases = 2;
		int maxExposures = 2;

		Patient patient = new Patient(maxDiseases, maxExposures);

		UUID dieaseId1 = UUID.randomUUID();
		UUID dieaseId2 = UUID.randomUUID();
		UUID dieaseId3 = UUID.randomUUID();

		patient.addDiseaseId(dieaseId1);
		patient.addDiseaseId(dieaseId2);
		patient.addDiseaseId(dieaseId3);

		UUID[] diseaseIds = patient.getDiseaseIds();

		assertEquals(dieaseId1, diseaseIds[0]);
		assertEquals(dieaseId2, diseaseIds[1]);
		assertEquals(dieaseId3, diseaseIds[2]);
	}

	@Test
	public void testAddExposure() {
		int maxDiseases = 2;
		int maxExposures = 3;

		Patient patient = new Patient(maxDiseases, maxExposures);

		LocalDateTime datetime1 = LocalDateTime.now();
		UUID patientId1 = UUID.randomUUID();
		String exposureType1 = ExposureConstants.DIRECT_EXPOSURE;
		Exposure exposure1 = new Exposure(datetime1, patientId1, exposureType1);

		LocalDateTime datetime2 = LocalDateTime.now();
		UUID patientId2 = UUID.randomUUID();
		String exposureType2 = ExposureConstants.INDIRECT_EXPOSURE;
		Exposure exposure2 = new Exposure(datetime2, patientId2, exposureType2);

		LocalDateTime datetime3 = LocalDateTime.now();
		UUID patientId3 = UUID.randomUUID();
		String exposureType3 = ExposureConstants.DIRECT_EXPOSURE;
		Exposure exposure3 = new Exposure(datetime3, patientId3, exposureType3);

		patient.addExposure(exposure1);
		patient.addExposure(exposure2);
		patient.addExposure(exposure3);

		Exposure[] exposures = patient.getExposures();

		assertEquals(exposure1, exposures[0]);
		assertEquals(exposure2, exposures[1]);
		assertEquals(exposure3, exposures[2]);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundExceptionForAddExposure() {
		int maxDiseases = 2;
		int maxExposures = 2;

		Patient patient = new Patient(maxDiseases, maxExposures);

		LocalDateTime datetime1 = LocalDateTime.now();
		UUID patientId1 = UUID.randomUUID();
		String exposureType1 = ExposureConstants.DIRECT_EXPOSURE;
		Exposure exposure1 = new Exposure(datetime1, patientId1, exposureType1);

		LocalDateTime datetime2 = LocalDateTime.now();
		UUID patientId2 = UUID.randomUUID();
		String exposureType2 = ExposureConstants.INDIRECT_EXPOSURE;
		Exposure exposure2 = new Exposure(datetime2, patientId2, exposureType2);

		LocalDateTime datetime3 = LocalDateTime.now();
		UUID patientId3 = UUID.randomUUID();
		String exposureType3 = ExposureConstants.DIRECT_EXPOSURE;
		Exposure exposure3 = new Exposure(datetime3, patientId3, exposureType3);

		patient.addExposure(exposure1);
		patient.addExposure(exposure2);
		patient.addExposure(exposure3);

		Exposure[] exposures = patient.getExposures();

		assertEquals(exposure1, exposures[0]);
		assertEquals(exposure2, exposures[1]);
		assertEquals(exposure3, exposures[2]);
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
}
