package edu.disease.asn4;

import static edu.disease.asn1.constants.ExposureConstants.DIRECT_EXPOSURE;

import java.util.UUID;

import edu.disease.asn3.DiseaseControlManager;
import edu.disease.asn3.Exposure;
import edu.disease.asn3.Patient;

public class ContactTrace {

	private final DiseaseControlManager diseaseControlManager;

	public ContactTrace(DiseaseControlManager diseaseControlManager) {
		this.diseaseControlManager = diseaseControlManager;
	}

	public PatientZero findPatientZero(Patient patient) {
		Exposure earliestExposure = findEarliestExposure(patient.getExposures());
		boolean exposed = earliestExposure != null;

		PatientZero patientZero = new PatientZero();
		patientZero.setPatient(exposed ? diseaseControlManager.getPatient(earliestExposure.getPatientId()) : null);
		patientZero.setExposureDateTime(exposed ? earliestExposure.getDateTime() : null);
		patientZero.setExposed(exposed);

		return patientZero;
	}

	private Exposure findEarliestExposure(Exposure[] exposures) {
		Exposure priorEarliestExposure = null;

		for (Exposure exposure : exposures) {
			if (exposure != null && DIRECT_EXPOSURE.equals(exposure.getExposureType())) {
				if (priorEarliestExposure == null
						|| exposure.getDateTime().isBefore(priorEarliestExposure.getDateTime())) {
					priorEarliestExposure = exposure;
				}
				// Recursively find earliest exposure for the patient in this exposure
				UUID patientId = exposure.getPatientId();
				if (patientId != null) {
					Patient patient = diseaseControlManager.getPatient(patientId);

					if (patient != null) {
						Exposure patientEarliestExposure = findEarliestExposure(patient.getExposures());
						if (patientEarliestExposure != null) {
							if (priorEarliestExposure == null || patientEarliestExposure.getDateTime()
									.isBefore(priorEarliestExposure.getDateTime())) {
								priorEarliestExposure = patientEarliestExposure;
							}
						}
					}
				}
			}

		}
		return priorEarliestExposure;
	}
}
