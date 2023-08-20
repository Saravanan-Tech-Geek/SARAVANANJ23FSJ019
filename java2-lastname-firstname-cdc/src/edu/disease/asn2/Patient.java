package edu.disease.asn2;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import edu.disease.asn1.Exposure;
import exception.UnknownExposureTypeException;

/**
 * 
 * @author Saravanan Selvaraj
 * @version 1.0.0
 */
public class Patient implements Comparable<Patient> {
	private UUID patientId;
	private String firstName;
	private String lastName;
	private Exposure[] exposures;
	private UUID[] diseaseIds;

	public Patient(int maxDiseases, int maxExposures) {
		if (maxDiseases <= 0 || maxExposures <= 0) {
			throw new UnknownExposureTypeException("maxDiseases and maxExposure must be positive values");
		}
		this.diseaseIds = new UUID[maxDiseases];
		this.exposures = new Exposure[maxExposures];

	}

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

	public boolean isDiseaseIdsFull() {
		for (UUID diseaseId : diseaseIds) {
			if (diseaseId == null) {
				return false;
			}
		}
		return true;
	}

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

	private boolean isExposureArrayFull() {
		for (Exposure exposure : exposures) {
			if (exposure == null) {
				return false;
			}
		}
		return true;
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
	public Exposure[] getExposures() {
		return exposures;
	}

	/**
	 * @return the diseaseIds
	 */
	public UUID[] getDiseaseIds() {
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
				+ ", exposures=" + Arrays.toString(exposures) + ", diseaseIds=" + Arrays.toString(diseaseIds) + "]";
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
		// if lastNames are equal , compare by firstNames
		int firstNameComparison = this.firstName.compareToIgnoreCase(that.firstName);

		return firstNameComparison;
	}

	public boolean hasExposure(Exposure exposure) {
		for (Exposure e : exposures) {
            if (e != null && e.equals(exposure)) {
                return true;
            }
        }
        return false;
    }

	public boolean hasDisease(UUID diseaseId) {
		for (UUID d : diseaseIds) {
            if (d != null && d.equals(diseaseId)) {
                return true;
            }
        }
        return false;
	}

}
