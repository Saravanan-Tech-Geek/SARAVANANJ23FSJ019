package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure;

/**
 * The Class DiseaseControlManagerImpl.
 */
public class DiseaseControlManagerImpl implements DiseaseControlManager {

	/** The diseases. */
	private Disease[] diseases;
	
	/** The patients. */
	private Patient[] patients;

	/**
	 * Instantiates a new disease control manager impl.
	 *
	 * @param maxDiseases the max diseases
	 * @param maxPatients the max patients
	 */
	DiseaseControlManagerImpl(int maxDiseases, int maxPatients) {
		if (maxDiseases <= 0 || maxPatients <= 0) {
			throw new IllegalArgumentException("Supplied Integer cannot be used to initialize the arrays");
		}
		this.patients = new Patient[maxPatients];
		this.diseases = new Disease[maxDiseases];
	}

	/**
	 * Adds the disease.
	 *
	 * @param name the name
	 * @param isInfectious the is infectious
	 * @return the disease
	 */
	@Override
	public Disease addDisease(String name, Boolean isInfectious) {
		if (isDiseasesArrayFull()) {
			throw new IllegalStateException("Diseases Array is full");
		}
		if(name == null) {
			throw new IllegalArgumentException("provide a valid name");
		}
		Disease newDisease;

		if (isInfectious) {
			newDisease = new InfectiousDisease();
		} else {
			newDisease = new NonInfectiousDisease();
		}
		
		newDisease.setName(name);
		newDisease.setDiseaseId(UUID.randomUUID());

		for (int i = 0; i < diseases.length; i++) {
			if (diseases[i] == null) {
				diseases[i] = newDisease;
				break;
			}
		}

		return newDisease;
	}

	/**
	 * Checks if is diseases array full.
	 *
	 * @return true, if is diseases array full
	 */
	private boolean isDiseasesArrayFull() {
		// TODO Auto-generated method stub
		for (Disease disease : diseases) {
			if (disease == null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets the disease.
	 *
	 * @param diseaseId the disease id
	 * @return the disease
	 */
	@Override
	public Disease getDisease(UUID diseaseId) {
		for (Disease disease : diseases) {
			if (disease.getDiseaseId().equals(diseaseId)) {
				return disease;
			}
		}
		return null;
	}

	/**
	 * Adds the patient.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param maxDiseases the max diseases
	 * @param maxExposures the max exposures
	 * @return the patient
	 */
	@Override
	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures) {
		if (isPatientArrayFull()) {
			throw new IllegalStateException("Patients Array is full");
		}
		Patient patient = new Patient(maxDiseases, maxExposures);
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setPatientId(UUID.randomUUID());

		for (int i = 0; i < patients.length; i++) {
			if (patients[i] == null) {
				patients[i] = patient;
				break;
			}
		}

		return patient;
	}

	/**
	 * Checks if is patient array full.
	 *
	 * @return true, if is patient array full
	 */
	private boolean isPatientArrayFull() {
		for (Patient patient : patients) {
			if (patient == null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets the patient.
	 *
	 * @param patientId the patient id
	 * @return the patient
	 */
	@Override
	public Patient getPatient(UUID patientId) {
		for (Patient patient : patients) {
			if (patient.getPatientId().equals(patientId)) {
				return patient;
			}
		}
		return null;
	}

	/**
	 * Adds the disease to patient.
	 *
	 * @param patientId the patient id
	 * @param diseaseId the disease id
	 */
	@Override
	public void addDiseaseToPatient(UUID patientId, UUID diseaseId) {

		for (Patient patient : patients) {
			if (patient.getPatientId().equals(patientId)) {
				for (Disease disease : diseases) {
					if (disease.getDiseaseId().equals(diseaseId)) {
						patient.addDiseaseId(disease.getDiseaseId());
						return;
					} else {
						throw new IllegalArgumentException("DiseaseId is not associated with diseaseList");
					}
				}
			} else {
				throw new IllegalArgumentException("PatientId is not associated with patientList");
			}
		}

	}

	/**
	 * Adds the exposure to patient.
	 *
	 * @param patientId the patient id
	 * @param exposure the exposure
	 */
	@Override
	public void addExposureToPatient(UUID patientId, Exposure exposure) {
		for (Patient patient : patients) {
			if (patient.getPatientId().equals(patientId)) {
				patient.addExposure(exposure);
				return;
			} else {
				throw new IllegalArgumentException("PatientId is not associated with patientList");
			}
		}
	}

}
