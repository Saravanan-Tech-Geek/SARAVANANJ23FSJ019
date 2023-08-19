package edu.disease.asn2;

import java.util.Objects;
import java.util.UUID;

/**
 * @author Saravanan Selvaraj
 * @version 1.0.0
 */
abstract class Disease {
	abstract String[] getExamples();
	private UUID diseaseId;
	private String name;

	/**
	 * @return the diseaseId
	 */
	public UUID getDiseaseId() {
		return diseaseId;
	}

	/**
	 * @param diseaseId the diseaseId to set
	 */
	public void setDiseaseId(UUID diseaseId) {
		this.diseaseId = diseaseId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diseaseId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Disease other = (Disease) obj;
		return Objects.equals(diseaseId, other.diseaseId);
	}

	@Override
	public String toString() {
		return "Disease [diseaseId=" + diseaseId + ", name=" + name + "]";
	}

}
