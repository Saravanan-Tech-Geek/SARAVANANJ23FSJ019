package edu.disease.asn6;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Class DiseaseFileRepository.
 * @author Saravanan Selvaraj
 * @version 1.0.0
 */
public class DiseaseFileRepository implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The folder path. */
    private String folderPath;

    /**
     * Instantiates a new disease file repository.
     *
     * @param folderPath the folder path
     */
    // Constructor to initialize the folderPath
    public DiseaseFileRepository(String folderPath) {
        if (folderPath == null) {
            throw new IllegalArgumentException("Folder path cannot be null");
        }
        this.folderPath = folderPath;
    }

    /**
     * Save.
     *
     * @param diseases the diseases
     * @param patients the patients
     */
    public void save(List<Disease> diseases, List<Patient> patients) {
        saveDiseases(diseases);
        savePatients(patients);
    }

    /**
     * Inits the.
     *
     * @return the disease and patient
     */
    public DiseaseAndPatient init() {
        List<Disease> diseases = deserializeDiseases();
        List<Patient> patients = deserializePatients();

        return new DiseaseAndPatient(
                diseases.toArray(new Disease[diseases.size()]),
                patients.toArray(new Patient[patients.size()])
        );
    }
    
    /**
     * Save diseases.
     *
     * @param diseases the diseases
     */
    private void saveDiseases(List<Disease> diseases) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(folderPath + "diseases.dat"))) {
            oos.writeObject(diseases.toArray(new Disease[0]));
            System.out.println("Diseases data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving diseases data: " + e.getMessage());
        }
    }

    /**
     * Save patients.
     *
     * @param patients the patients
     */
    private void savePatients(List<Patient> patients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(folderPath + "patients.dat"))) {
            oos.writeObject(patients.toArray(new Patient[0]));
            System.out.println("Patients data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving patients data: " + e.getMessage());
        }
    }

    /**
     * Deserialize diseases.
     *
     * @return the list
     */
    private List<Disease> deserializeDiseases() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folderPath + "diseases.dat"))) {
            return new ArrayList<>(Arrays.asList((Disease[]) ois.readObject()));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error deserializing diseases data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Deserialize patients.
     *
     * @return the list
     */
    private List<Patient> deserializePatients() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(folderPath + "patients.dat"))) {
            return new ArrayList<>(Arrays.asList((Patient[]) ois.readObject()));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error deserializing patients data: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
