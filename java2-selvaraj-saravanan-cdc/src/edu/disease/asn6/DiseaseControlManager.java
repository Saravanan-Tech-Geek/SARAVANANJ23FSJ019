package edu.disease.asn6;

import java.util.UUID;

public interface DiseaseControlManager {

	/**
	 * @param name
	 * @param isInfectious
	 * @return Disease Adds a new disease to application
	 */
	public Disease addDisease(String name, Boolean isInfectious);

	/**
	 * 
	 * @param diseaseId
	 * @return Returns the disease or null if not found
	 */
	public Disease getDisease(UUID diseaseId);

	/**
	 * Adds a new patient to the application.Supply the max parameters to the
	 * patient Constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param maxDiseases
	 * @param maxExposures
	 * @return Patient
	 */
	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures);

	/**
	 * 
	 * @param patientId
	 * @return Returns the patient or null if not found
	 */
	public Patient getPatient(UUID patientId);

	/**
	 * Add disease to a patient
	 * 
	 * @param patientID
	 * @param diseaseId
	 */
	public void addDiseaseToPatient(UUID patientID, UUID diseaseId);

	/**
	 * Adds an Exposure instance to a patient
	 * 
	 * @param patientId
	 * @param exposure
	 */
	public void addExposureToPatient(UUID patientId, Exposure exposure);
}
