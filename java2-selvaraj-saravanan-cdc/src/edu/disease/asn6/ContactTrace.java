package edu.disease.asn6;

import static edu.disease.asn1.constants.ExposureConstants.DIRECT_EXPOSURE;

import java.util.List;
import java.util.UUID;

/**
 * The Class ContactTrace.
 * @author Saravanan Selvaraj
 * @version 1.0.0
 */
public class ContactTrace {

	/** The disease control manager. */
	private final DiseaseControlManager diseaseControlManager;

	/**
	 * Instantiates a new contact trace.
	 *
	 * @param diseaseControlManager the disease control manager
	 */
	public ContactTrace(DiseaseControlManager diseaseControlManager) {
		this.diseaseControlManager = diseaseControlManager;
	}

	/**
	 * Find patient zero.
	 *
	 * @param patient the patient
	 * @return the patient zero
	 */
	public PatientZero findPatientZero(Patient patient) {
		Exposure earliestExposure = findEarliestExposure(patient.getExposures());
		boolean exposed = earliestExposure != null;

		PatientZero patientZero = new PatientZero();
		patientZero.setPatient(exposed ? diseaseControlManager.getPatient(earliestExposure.getPatientId()) : null);
		patientZero.setExposureDateTime(exposed ? earliestExposure.getDateTime() : null);
		patientZero.setExposed(exposed);

		return patientZero;
	}

	/**
	 * Find earliest exposure.
	 *
	 * @param exposures the exposures
	 * @return the exposure
	 */
	private Exposure findEarliestExposure(List<Exposure> exposures) {
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
