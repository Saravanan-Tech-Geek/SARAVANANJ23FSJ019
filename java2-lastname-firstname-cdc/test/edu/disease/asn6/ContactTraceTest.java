package edu.disease.asn6;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class ContactTraceTest {
	public DiseaseControlManager diseaseControlManager;

	@Test
	void findPatientZeroNotExposedTest() {
		// Create a DiseaseControlManager implementation for testing
		DiseaseControlManager diseaseControlManager = new DiseaseControlManagerImpl(10, 10);

		// Create ContactTrace instance with the actual DiseaseControlManager
		// implementation
		ContactTrace contactTrace = new ContactTrace(diseaseControlManager);
		// Create a sample patient without exposures
		Patient patient = new Patient(5, 10);

		// Execute the method under test
		PatientZero patientZero = contactTrace.findPatientZero(patient);

		// Assert the result
		assertNotNull(patientZero);
		assertNull(patientZero.getPatient());
		assertNull(patientZero.getExposureDateTime());
		assertFalse(patientZero.isExposed());
	}
}
