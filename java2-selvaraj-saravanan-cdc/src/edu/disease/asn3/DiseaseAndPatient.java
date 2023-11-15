package edu.disease.asn3;

/**
 * The Class DiseaseAndPatient.
 */
public class DiseaseAndPatient {
	
	/** The diseases. */
	private Disease[] diseases;
	
	/** The patients. */
	private Patient[] patients;

	/**
	 * Instantiates a new disease and patient.
	 *
	 * @param diseases the diseases
	 * @param patients the patients
	 */
	public DiseaseAndPatient(Disease[] diseases, Patient[] patients) {
		this.diseases = diseases;
		this.patients = patients;
	}


	/**
	 * Gets the diseases.
	 *
	 * @return the diseases
	 */
	public Disease[] getDiseases() {
		return diseases;
	}

	/**
	 * Sets the diseases.
	 *
	 * @param diseases the new diseases
	 */
	public void setDiseases(Disease[] diseases) {
		this.diseases = diseases;
	}

	/**
	 * Gets the patients.
	 *
	 * @return the patients
	 */
	public Patient[] getPatients() {
		return patients;
	}

	/**
	 * Sets the patients.
	 *
	 * @param patients the new patients
	 */
	public void setPatients(Patient[] patients) {
		this.patients = patients;
	}

}
