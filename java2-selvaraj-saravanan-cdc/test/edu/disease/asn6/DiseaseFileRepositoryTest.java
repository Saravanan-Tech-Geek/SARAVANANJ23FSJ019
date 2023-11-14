package edu.disease.asn6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DiseaseFileRepositoryTest implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String TEST_FOLDER_PATH = "src\\test\\resources\\"; // Change this to a suitable test folder path
    private Disease disease;

    @BeforeAll
    static void setUpBeforeAll() {
        // Clean up the test data folder before each test
        File testDataFolder = new File(TEST_FOLDER_PATH);
        if (testDataFolder.exists()) {
            deleteFolder(testDataFolder);
        }
    }

    @BeforeEach
    void setUp() {
        disease = new Disease() {
            private static final long serialVersionUID = 1L;

			@Override
			List<String> getExamples() {
				
				return null;
			}

            
        };
    }

    @Test
    void saveAndInitTest() {
        // Arrange
        DiseaseFileRepository repository = new DiseaseFileRepository(TEST_FOLDER_PATH);

        // Create test data
        UUID uuid = UUID.randomUUID();
        disease.setDiseaseId(uuid);
        String name = "Test Disease";
        disease.setName(name);

        Disease[] diseases = {disease, disease};
        List<Disease> diseasesList = Arrays.asList(disease, disease);


        Patient patient = new Patient(3, 2);
        patient.setPatientId(UUID.randomUUID());
        patient.setFirstName("Sara");
        patient.setLastName("ravanan");

        Patient[] patients = {patient, patient};
        List<Patient> patientsList = Arrays.asList(patient, patient);
        
        // Act
        repository.save(diseasesList, patientsList);
        DiseaseAndPatient loadedData = repository.init();

        // Assert
        assertArrayEquals(diseases, loadedData.getDiseases().toArray(new Disease[0]), "Saved and loaded diseases should be equal");
        assertArrayEquals(patients, loadedData.getPatients().toArray(new Patient[0]), "Saved and loaded patients should be equal");
    }

    // Helper method to delete a folder and its contents
    private static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.delete();
                }
            }
        }
        folder.delete();
    }
}
