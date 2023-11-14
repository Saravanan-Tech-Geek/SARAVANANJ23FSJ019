package edu.disease.asn6;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DiseaseControlManagerImpl implements DiseaseControlManager {

	private List<Disease> diseases;
	private List<Patient> patients;
	private final int maxDiseases;
	private final int maxPatients;

	public DiseaseControlManagerImpl(int maxDiseases, int maxPatients) {
		if (maxDiseases <= 0 || maxPatients <= 0) {
			throw new IllegalArgumentException("Supplied Integer cannot be used to initialize the lists");
		}
		this.maxDiseases = maxDiseases;
		this.maxPatients = maxPatients;
		this.patients = new ArrayList<>();
		this.diseases = new ArrayList<>();
	}

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

	private boolean isDiseasesListFull() {
		return diseases.size() >= maxDiseases;
	}

	@Override
	public Disease getDisease(UUID diseaseId) {
		for (Disease disease : diseases) {
			if (disease.getDiseaseId().equals(diseaseId)) {
				return disease;
			}
		}
		return null;
	}

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

	private boolean isPatientsListFull() {
		return patients.size() >= maxPatients;
	}

	@Override
	public Patient getPatient(UUID patientId) {
		for (Patient patient : patients) {
			if (patient.getPatientId().equals(patientId)) {
				return patient;
			}
		}
		return null;
	}

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
