package edu.disease.asn2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.UUID;

class NonInfectiousDiseaseTest {

    @Test
    void testGetExamples() {
        NonInfectiousDisease nonInfectiousDisease = new NonInfectiousDisease();
        String[] expectedExamples = {
            "Diabetes",
            "Heart Disease",
            "Asthma",
            "Cancer"
        };

        assertArrayEquals(expectedExamples, nonInfectiousDisease.getExamples());
    }

    @Test
    void testDiseaseIdAndName() {
        NonInfectiousDisease nonInfectiousDisease = new NonInfectiousDisease();
        UUID uuid = UUID.randomUUID();
        String name = "Cancer";

        nonInfectiousDisease.setDiseaseId(uuid);
        nonInfectiousDisease.setName(name);

        assertEquals(uuid, nonInfectiousDisease.getDiseaseId());
        assertEquals(name, nonInfectiousDisease.getName());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();

        NonInfectiousDisease disease1 = new NonInfectiousDisease();
        disease1.setDiseaseId(uuid1);

        NonInfectiousDisease disease2 = new NonInfectiousDisease();
        disease2.setDiseaseId(uuid1);

        NonInfectiousDisease disease3 = new NonInfectiousDisease();
        disease3.setDiseaseId(uuid2);

        assertEquals(disease1, disease2);
        assertNotEquals(disease1, disease3);
        assertEquals(disease1.hashCode(), disease2.hashCode());
    }

    @Test
    void testToString() {
        UUID uuid = UUID.randomUUID();
        String name = "Diabetes";

        NonInfectiousDisease nonInfectiousDisease = new NonInfectiousDisease();
        nonInfectiousDisease.setDiseaseId(uuid);
        nonInfectiousDisease.setName(name);

        String expectedString = "Disease [diseaseId=" + uuid + ", name=" + name + "]";
        assertEquals(expectedString, nonInfectiousDisease.toString());
    }
}

