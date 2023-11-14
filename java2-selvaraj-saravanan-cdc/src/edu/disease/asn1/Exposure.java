package edu.disease.asn1;

import static edu.disease.asn1.constants.ExposureConstants.DIRECT_EXPOSURE;
import static edu.disease.asn1.constants.ExposureConstants.INDIRECT_EXPOSURE;
import exception.UnknownExposureTypeException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * 
 * @author Saravanan Selvaraj
 * @version 1.0.0
 */
public class Exposure {

	private LocalDateTime dateTime;
	private UUID patientId;
	private String exposureType;

	/**
	 * @param dateTime
	 * @param patientId
	 * @param exposureType
	 */
	public Exposure(LocalDateTime dateTime, UUID patientId, String exposureType) {
		super();
		this.dateTime = dateTime;
		this.patientId = patientId;
		this.exposureType = exposureType;
	}

	/**
	 * @return the dateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
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
	 * @return the exposureType
	 */
	public String getExposureType() {
		return exposureType;
	}

	/**
	 * @param exposureType the exposureType to set
	 */
	public void setExposureType(String exposureType) {
		if (exposureType.equalsIgnoreCase(DIRECT_EXPOSURE) || exposureType.equalsIgnoreCase(INDIRECT_EXPOSURE)) {
			this.exposureType = exposureType;
		} else {
			throw new UnknownExposureTypeException(
					"IllegalArgumentExpetion: Unknown exposure type = " + exposureType + "'");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateTime, patientId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exposure other = (Exposure) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(patientId, other.patientId);
	}

	@Override
	public String toString() {
		return "Exposure [dateTime=" + dateTime + ", patientId=" + patientId + ", exposureType=" + exposureType + "]";
	}

}
