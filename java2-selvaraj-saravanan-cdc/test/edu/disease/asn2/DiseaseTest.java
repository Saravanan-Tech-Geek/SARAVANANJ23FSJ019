package edu.disease.asn2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

class DiseaseTest {
    private Disease disease;

    @BeforeEach
    void setUp() {
        disease = new Disease() {
            @Override
            String[] getExamples() {
                return new String[0];
            }
        };
    }

    @Test
    void testSetAndGetDiseaseId() {
        UUID uuid = UUID.randomUUID();
        disease.setDiseaseId(uuid);
        assertEquals(uuid, disease.getDiseaseId());
    }

    @Test
    void testSetAndGetName() {
        String name = "Test Disease";
        disease.setName(name);
        assertEquals(name, disease.getName());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        disease.setDiseaseId(uuid1);

        Disease sameIdDisease = new Disease() {
            @Override
            String[] getExamples() {
                return new String[0];
            }
        };
        sameIdDisease.setDiseaseId(uuid1);

        Disease differentIdDisease = new Disease() {
            @Override
            String[] getExamples() {
                return new String[0];
            }
        };
        differentIdDisease.setDiseaseId(uuid2);
        
        assertEquals(disease.hashCode(),sameIdDisease.hashCode());
        assertEquals(disease, sameIdDisease);
        assertNotEquals(disease, differentIdDisease);
        
    }

    @Test
    void testToString() {
        UUID uuid = UUID.randomUUID();
        String name = "Test Disease";
        disease.setDiseaseId(uuid);
        disease.setName(name);
        String expectedString = "Disease [diseaseId=" + uuid + ", name=" + name + "]";
        assertEquals(expectedString, disease.toString());
    }
}

