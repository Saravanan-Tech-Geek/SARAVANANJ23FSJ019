package edu.disease.asn6;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The Class DiseaseControlManagerImpl.
 * @author Saravanan Selvaraj
 * @version 1.0.0
 */
public class DiseaseControlManagerImpl implements DiseaseControlManager {

	/** The diseases. */
	private List<Disease> diseases;
	
	/** The patients. */
	private List<Patient> patients;
	
	/** The max diseases. */
	private final int maxDiseases;
	
	/** The max patients. */
	private final int maxPatients;

	/**
	 * Instantiates a new disease control manager impl.
	 *
	 * @param maxDiseases the max diseases
	 * @param maxPatients the max patients
	 */
	public DiseaseControlManagerImpl(int maxDiseases, int maxPatients) {
		if (maxDiseases <= 0 || maxPatients <= 0) {
			throw new IllegalArgumentException("Supplied Integer cannot be used to initialize the lists");
		}
		this.maxDiseases = maxDiseases;
		this.maxPatients = maxPatients;
		this.patients = new ArrayList<>();
		this.diseases = new ArrayList<>();
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
		if (isDiseasesListFull()) {
			throw new IllegalStateException("Diseases List is full");
		}
		if (name == null) {
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

		diseases.add(newDisease);

		return newDisease;
	}

	/**
	 * Checks if is diseases list full.
	 *
	 * @return true, if is diseases list full
	 */
	private boolean isDiseasesListFull() {
		return diseases.size() >= maxDiseases;
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
		if (isPatientsListFull()) {
			throw new IllegalStateException("Patients List is full");
		}
		Patient patient = new Patient(maxDiseases, maxExposures);
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setPatientId(UUID.randomUUID());

		patients.add(patient);

		return patient;
	}

	/**
	 * Checks if is patients list full.
	 *
	 * @return true, if is patients list full
	 */
	private boolean isPatientsListFull() {
		return patients.size() >= maxPatients;
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

		Patient patient = getPatient(patientId);
		Disease disease = getDisease(diseaseId);

		if (patient != null && disease != null) {
			patient.addDiseaseId(disease.getDiseaseId());
		} else {
			throw new IllegalArgumentException("Invalid PatientId or DiseaseId");
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
		Patient patient = getPatient(patientId);

		if (patient != null) {
			patient.addExposure(exposure);
		} else {
			throw new IllegalArgumentException("Invalid PatientId");
		}
	}
}
