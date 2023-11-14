package edu.disease.asn4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.disease.asn3.DiseaseControlManager;
import edu.disease.asn3.DiseaseControlManagerImpl;

import edu.disease.asn3.Patient;
//import static edu.disease.asn1.constants.ExposureConstants.DIRECT_EXPOSURE;

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
