package edu.disease.asn2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.UUID;

class InfectiousDiseaseTest {

    @Test
    void testGetExamples() {
        InfectiousDisease infectiousDisease = new InfectiousDisease();
        String[] expectedExamples = {
            "Influenza",
            "Tuberculosis",
            "COVID-19",
            "Malaria"
        };

        assertArrayEquals(expectedExamples, infectiousDisease.getExamples());
    }

    @Test
    void testDiseaseIdAndName() {
        InfectiousDisease infectiousDisease = new InfectiousDisease();
        UUID uuid = UUID.randomUUID();
        String name = "COVID-19";

        infectiousDisease.setDiseaseId(uuid);
        infectiousDisease.setName(name);

        assertEquals(uuid, infectiousDisease.getDiseaseId());
        assertEquals(name, infectiousDisease.getName());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();

        InfectiousDisease disease1 = new InfectiousDisease();
        disease1.setDiseaseId(uuid1);

        InfectiousDisease disease2 = new InfectiousDisease();
        disease2.setDiseaseId(uuid1);

        InfectiousDisease disease3 = new InfectiousDisease();
        disease3.setDiseaseId(uuid2);

        assertEquals(disease1, disease2);
        assertNotEquals(disease1, disease3);
        assertEquals(disease1.hashCode(), disease2.hashCode());
    }

    @Test
    void testToString() {
        UUID uuid = UUID.randomUUID();
        String name = "Malaria";

        InfectiousDisease infectiousDisease = new InfectiousDisease();
        infectiousDisease.setDiseaseId(uuid);
        infectiousDisease.setName(name);

        String expectedString = "Disease [diseaseId=" + uuid + ", name=" + name + "]";
        assertEquals(expectedString, infectiousDisease.toString());
    }
}

