package edu.disease.asn6;

import java.time.LocalDateTime;

/**
 * The Class PatientZero.
 * @author Saravanan Selvaraj
 * @version 1.0.0
 */
public class PatientZero {
	
	/** The patient. */
	private Patient patient;
	
	/** The exposure date time. */
	private LocalDateTime exposureDateTime;
	
	/** The exposed. */
	private boolean exposed;
	
	/**
	 * Gets the patient.
	 *
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Sets the patient.
	 *
	 * @param patient the new patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * Gets the exposure date time.
	 *
	 * @return the exposure date time
	 */
	public LocalDateTime getExposureDateTime() {
		return exposureDateTime;
	}

	/**
	 * Sets the exposure date time.
	 *
	 * @param exposureDateTime the new exposure date time
	 */
	public void setExposureDateTime(LocalDateTime exposureDateTime) {
		this.exposureDateTime = exposureDateTime;
	}

	/**
	 * Checks if is exposed.
	 *
	 * @return true, if is exposed
	 */
	public boolean isExposed() {
		return exposed;
	}

	/**
	 * Sets the exposed.
	 *
	 * @param exposed the new exposed
	 */
	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}

}
