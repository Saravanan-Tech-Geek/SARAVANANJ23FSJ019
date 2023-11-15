package edu.disease.asn6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import exception.UnknownExposureTypeException;


/**
 * The Class Patient.
 * @author Saravanan Selvaraj
 * @version 1.0.0
 */
public class Patient implements Comparable<Patient>, Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The patient id. */
	private UUID patientId;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The exposures. */
	private List<Exposure> exposures;
	
	/** The disease ids. */
	private List<UUID> diseaseIds;
	
	/** The max diseases. */
	private final int maxDiseases;
	
	/** The max exposures. */
	private final int maxExposures;

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
		this.maxDiseases = maxDiseases;
		this.maxExposures = maxExposures;
		this.diseaseIds = new ArrayList<>(maxDiseases);
		this.exposures = new ArrayList<>(maxExposures);
	}

	/**
	 * Adds the disease id.
	 *
	 * @param diseaseId the disease id
	 */
	public void addDiseaseId(UUID diseaseId) {
		if (isDiseaseIdsFull()) {
			throw new IndexOutOfBoundsException("Disease List is full");
		}
		diseaseIds.add(diseaseId);
	}

	/**
	 * Checks if is disease ids full.
	 *
	 * @return true, if is disease ids full
	 */
	public boolean isDiseaseIdsFull() {
		return diseaseIds.size() >= maxDiseases;  // Update with your logic
	}

	/**
	 * Adds the exposure.
	 *
	 * @param exposure the exposure
	 */
	public void addExposure(Exposure exposure) {
		if (isExposureListFull()) {
			throw new IndexOutOfBoundsException("Exposure List is full");
		}
		exposures.add(exposure);
	}

	/**
	 * Checks if is exposure list full.
	 *
	 * @return true, if is exposure list full
	 */
	public boolean isExposureListFull() {
		return exposures.size() >= maxExposures; // Update with your logic
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
	public List<Exposure> getExposures() {
		return exposures;
	}

	/**
	 * Gets the disease ids.
	 *
	 * @return the diseaseIds
	 */
	public List<UUID> getDiseaseIds() {
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
				+ ", exposures=" + exposures + ", diseaseIds=" + diseaseIds + "]";
	}

	/**
	 * Compare to.
	 *
	 * @param that the that
	 * @return the int
	 */
	@Override
	public int compareTo(Patient that) {
		// Check for null values and handle them appropriately
		if (this.lastName == null && that.lastName == null) {
			return 0;
		} else if (this.lastName == null) {
			return -1;
		} else if (that.lastName == null) {
			return 1;
		}

		int lastNameComparison = this.lastName.compareToIgnoreCase(that.lastName);

		if (lastNameComparison != 0) {
			return lastNameComparison;
		}
		
		if (this.firstName == null && that.firstName == null) {
			return 0;
		} else if (this.firstName == null) {
			return -1;
		} else if (that.firstName == null) {
			return 1;
		}
		// if lastNames are equal, compare by firstNames
		int firstNameComparison = this.firstName.compareToIgnoreCase(that.firstName);

		return firstNameComparison;
	}

	/**
	 * Checks for exposure.
	 *
	 * @param exposure the exposure
	 * @return true, if successful
	 */
	public boolean hasExposure(Exposure exposure) {
		return exposures.contains(exposure);
	}

	/**
	 * Checks for disease.
	 *
	 * @param diseaseId the disease id
	 * @return true, if successful
	 */
	public boolean hasDisease(UUID diseaseId) {
		return diseaseIds.contains(diseaseId);
	}
}
