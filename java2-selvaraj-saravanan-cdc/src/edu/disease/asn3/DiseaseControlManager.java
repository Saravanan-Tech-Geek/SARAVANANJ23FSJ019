package edu.disease.asn3;

import java.util.UUID;


/**
 * The Interface DiseaseControlManager.
 */
public interface DiseaseControlManager {

	/**
	 * Adds the disease.
	 *
	 * @param name the name
	 * @param isInfectious the is infectious
	 * @return Disease Adds a new disease to application
	 */
	public Disease addDisease(String name, Boolean isInfectious);

	/**
	 * Gets the disease.
	 *
	 * @param diseaseId the disease id
	 * @return Returns the disease or null if not found
	 */
	public Disease getDisease(UUID diseaseId);

	/**
	 * Adds a new patient to the application.Supply the max parameters to the
	 * patient Constructor
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param maxDiseases the max diseases
	 * @param maxExposures the max exposures
	 * @return Patient
	 */
	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures);

	/**
	 * Gets the patient.
	 *
	 * @param patientId the patient id
	 * @return Returns the patient or null if not found
	 */
	public Patient getPatient(UUID patientId);

	/**
	 * Add disease to a patient.
	 *
	 * @param patientID the patient ID
	 * @param diseaseId the disease id
	 */
	public void addDiseaseToPatient(UUID patientID, UUID diseaseId);

	/**
	 * Adds an Exposure instance to a patient.
	 *
	 * @param patientId the patient id
	 * @param exposure the exposure
	 */
	public void addExposureToPatient(UUID patientId, Exposure exposure);
}
