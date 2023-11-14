package edu.disease.asn6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import exception.UnknownExposureTypeException;

public class Patient implements Comparable<Patient>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private UUID patientId;
	private String firstName;
	private String lastName;
	private List<Exposure> exposures;
	private List<UUID> diseaseIds;
	private final int maxDiseases;
	private final int maxExposures;

	public Patient(int maxDiseases, int maxExposures) {
		if (maxDiseases <= 0 || maxExposures <= 0) {
			throw new UnknownExposureTypeException("maxDiseases and maxExposure must be positive values");
		}
		this.maxDiseases = maxDiseases;
		this.maxExposures = maxExposures;
		this.diseaseIds = new ArrayList<>(maxDiseases);
		this.exposures = new ArrayList<>(maxExposures);
	}

	public void addDiseaseId(UUID diseaseId) {
		if (isDiseaseIdsFull()) {
			throw new IndexOutOfBoundsException("Disease List is full");
		}
		diseaseIds.add(diseaseId);
	}

	public boolean isDiseaseIdsFull() {
		return diseaseIds.size() >= maxDiseases;  // Update with your logic
	}

	public void addExposure(Exposure exposure) {
		if (isExposureListFull()) {
			throw new IndexOutOfBoundsException("Exposure List is full");
		}
		exposures.add(exposure);
	}

	public boolean isExposureListFull() {
		return exposures.size() >= maxExposures; // Update with your logic
	}

	/**
	 * @return the patientId
	 */
	public UUID getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the exposures
	 */
	public List<Exposure> getExposures() {
		return exposures;
	}

	/**
	 * @return the diseaseIds
	 */
	public List<UUID> getDiseaseIds() {
		return diseaseIds;
	}

	@Override
	public int hashCode() {
		return Objects.hash(patientId);
	}

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

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", exposures=" + exposures + ", diseaseIds=" + diseaseIds + "]";
	}

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

	public boolean hasExposure(Exposure exposure) {
		return exposures.contains(exposure);
	}

	public boolean hasDisease(UUID diseaseId) {
		return diseaseIds.contains(diseaseId);
	}
}
