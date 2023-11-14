package edu.disease.asn3;

import java.io.*;

public class DiseaseFileRepository implements Serializable {

    private static final long serialVersionUID = 1L;
	private String folderPath;

    // Constructor to initialize the folderPath
    public DiseaseFileRepository(String folderPath) {
        if (folderPath == null) {
            throw new IllegalArgumentException("Folder path cannot be null");
        }
        this.folderPath = folderPath;
    }

    public void save(Disease[] diseases, Patient[] patients) {
        saveDiseases(diseases);
        savePatients(patients);
    }

    public DiseaseAndPatient init() {
        Disease[] diseases = deserializeDiseases();
        Patient[] patients = deserializePatients();

        return new DiseaseAndPatient(diseases, patients);
    }

    private void saveDiseases(Disease[] diseases) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(folderPath + "diseases.dat"))) {
            oos.writeObject(diseases);
            System.out.println("Diseases data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving diseases data: " + e.getMessage());
        }
    }

    private void savePatients(Patient[] patients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(folderPath + "patients.dat"))) {
            oos.writeObject(patients);
            System.out.println("Patients data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving patients data: " + e.getMessage());
        }
    }

    private Disease[] deserializeDiseases() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folderPath + "diseases.dat"))) {
            return (Disease[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error deserializing diseases data: " + e.getMessage());
            return null;
        }
    }

    private Patient[] deserializePatients() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folderPath + "patients.dat"))) {
            return (Patient[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error deserializing patients data: " + e.getMessage());
            return null;
        }
    }
}

