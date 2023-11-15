package edu.disease.asn6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Class DiseaseAndPatient.
 * @author Saravanan Selvaraj
 * @version 1.0.0
 */
public class DiseaseAndPatient {
    
    /** The diseases. */
    private List<Disease> diseases;
    
    /** The patients. */
    private List<Patient> patients;

    /**
     * Instantiates a new disease and patient.
     *
     * @param diseases the diseases
     * @param patients the patients
     */
    public DiseaseAndPatient(Disease[] diseases, Patient[] patients) {
    	this.diseases = new ArrayList<>(Arrays.asList(diseases));
    	this.patients = new ArrayList<>(Arrays.asList(patients));
    }

    /**
     * Gets the diseases.
     *
     * @return the diseases
     */
    public List<Disease> getDiseases() {
        return diseases;
    }

    /**
     * Sets the diseases.
     *
     * @param diseases the new diseases
     */
    public void setDiseases(Disease[] diseases) {
        this.diseases = Arrays.asList(diseases);
    }

    /**
     * Gets the patients.
     *
     * @return the patients
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Sets the patients.
     *
     * @param patients the new patients
     */
    public void setPatients(Patient[] patients) {
        this.patients = Arrays.asList(patients);
    }
}
