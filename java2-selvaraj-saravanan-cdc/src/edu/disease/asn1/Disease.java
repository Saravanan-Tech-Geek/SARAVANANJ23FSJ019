package edu.disease.asn1;

import java.util.Objects;
import java.util.UUID;

/**
 * The Class Disease.
 *
 * @author Saravanan Selvaraj
 * @version 1.0.0
 */
public class Disease {
	
	/** The disease id. */
	private UUID diseaseId;
	
	/** The name. */
	private String name;

	/**
	 * Gets the disease id.
	 *
	 * @return the diseaseId
	 */
	public UUID getDiseaseId() {
		return diseaseId;
	}

	/**
	 * Sets the disease id.
	 *
	 * @param diseaseId the diseaseId to set
	 */
	public void setDiseaseId(UUID diseaseId) {
		this.diseaseId = diseaseId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(diseaseId);
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
		Disease other = (Disease) obj;
		return Objects.equals(diseaseId, other.diseaseId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Disease [diseaseId=" + diseaseId + ", name=" + name + "]";
	}

}
