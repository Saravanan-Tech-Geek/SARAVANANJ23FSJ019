package edu.disease.asn1;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import exception.UnknownExposureTypeException;

/**
 * The Class Patient.
 *
 * @author Saravanan Selvaraj
 * @version 1.0.0
 */
public class Patient {
	
	/** The patient id. */
	private UUID patientId;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The exposures. */
	private Exposure[] exposures;
	
	/** The disease ids. */
	private UUID[] diseaseIds;

	/**
	 * Instantiates a new patient.
	 *
	 * @param maxDiseases the max diseases
	 * @param maxExposures the max exposures
	 */
	public Patient(int maxDiseases, int maxExposures) {
		if (maxDiseases <= 0 || maxExposures <= 0) {
			throw new UnknownExposureTypeException("maxDiseases and maxExposure must be positive values");
		}
		//this.diseaseIds = new UUID[maxDiseases];
		this.exposures = new Exposure[maxExposures];
		this.diseaseIds = new UUID[maxDiseases];
		
	}
	

	/**
	 * Adds the disease id.
	 *
	 * @param dieaseId the diease id
	 */
	public void addDiseaseId(UUID dieaseId) {
		if (isDiseaseIdsFull()) {
			throw new IndexOutOfBoundsException("Disease Array is full");
		}
		for (int i = 0; i < diseaseIds.length; i++) {
			if (diseaseIds[i] == null) {
				diseaseIds[i] = dieaseId;
				return;
			}
		}
	}

	/**
	 * Checks if is disease ids full.
	 *
	 * @return true, if is disease ids full
	 */
	public boolean isDiseaseIdsFull() {
		for (UUID diseaseId : diseaseIds) {
			if (diseaseId == null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Adds the exposure.
	 *
	 * @param exposure the exposure
	 */
	public void addExposure(Exposure exposure) {
		if (isExposureArrayFull()) {
			throw new IndexOutOfBoundsException("Exposure Array is full");
		}
		for (int i = 0; i < exposures.length; i++) {
			if (exposures[i] == null) {
				exposures[i] = exposure;
				return;
			}
		}
	}

	/**
	 * Checks if is exposure array full.
	 *
	 * @return true, if is exposure array full
	 */
	private boolean isExposureArrayFull() {
		for (Exposure exposure : exposures) {
			if (exposure == null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets the patient id.
	 *
	 * @return the patientId
	 */
	public UUID getPatientId() {
		return patientId;
	}

	/**
	 * Sets the patient id.
	 *
	 * @param patientId the patientId to set
	 */
	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the exposures.
	 *
	 * @return the exposures
	 */
	public Exposure[] getExposures() {
		return exposures;
	}

	/**
	 * Gets the disease ids.
	 *
	 * @return the diseaseIds
	 */
	public UUID[] getDiseaseIds() {
		return diseaseIds;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(patientId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(patientId, other.patientId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", exposures=" + Arrays.toString(exposures) + ", diseaseIds=" + Arrays.toString(diseaseIds) + "]";
	}

}
