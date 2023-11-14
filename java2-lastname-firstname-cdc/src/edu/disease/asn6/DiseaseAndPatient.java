package edu.disease.asn6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiseaseAndPatient {
    private List<Disease> diseases;
    private List<Patient> patients;

    public DiseaseAndPatient(Disease[] diseases, Patient[] patients) {
    	this.diseases = new ArrayList<>(Arrays.asList(diseases));
    	this.patients = new ArrayList<>(Arrays.asList(patients));
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Disease[] diseases) {
        this.diseases = Arrays.asList(diseases);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = Arrays.asList(patients);
    }
}
