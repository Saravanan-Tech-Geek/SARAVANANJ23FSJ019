package edu.disease.asn3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.Serializable;
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
            String[] getExamples() {
                return new String[0];
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
        
        Disease[] diseases = {disease,disease};
        
        Patient patient = new Patient(3, 2);
		patient.setPatientId(UUID.randomUUID());
		patient.setFirstName("Sara");
		patient.setLastName("ravanan");
		
        Patient[] patients = {patient,patient};

        // Act
        repository.save(diseases, patients);
        DiseaseAndPatient loadedData = repository.init();

        // Assert
        assertArrayEquals(diseases, loadedData.getDiseases(), "Saved and loaded diseases should be equal");
        assertArrayEquals(patients, loadedData.getPatients(), "Saved and loaded patients should be equal");
    }
    
//    @Test
//    void deserializeDiseasesTest() throws Exception {
//        InputStream diseasesStream = getClass().getClassLoader().getResourceAsStream(TEST_FOLDER_PATH + "diseases.dat");
//        Objects.requireNonNull(diseasesStream, "Diseases file not found in test resources");
//    	
//        try (ObjectInputStream ois = new ObjectInputStream(diseasesStream)) {
//            Disease[] loadedDiseases = (Disease[]) ois.readObject();
//            assertNotNull(loadedDiseases, "Loaded diseases should not be null");
//        }
//    }
//
//    @Test
//    void deserializePatientsTest() throws Exception {
//        InputStream patientsStream = getClass().getClassLoader().getResourceAsStream(TEST_FOLDER_PATH +"patients.dat");
//        Objects.requireNonNull(patientsStream, "Patients file not found in test resources");
//
//        try (ObjectInputStream ois = new ObjectInputStream(patientsStream)) {
//            Patient[] loadedPatients = (Patient[]) ois.readObject();
//            assertNotNull(loadedPatients, "Loaded patients should not be null");
//        }
//    }

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
