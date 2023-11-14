package edu.disease.asn6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class NonInfectiousDiseaseTest {

    @Test
    void testGetExamples() {
        NonInfectiousDisease nonInfectiousDisease = new NonInfectiousDisease();

        List<String> expectedExamples = List.of("Diabetes", "Heart Disease", "Asthma", "Cancer");
        List<String> actualExamples = nonInfectiousDisease.getExamples();

        assertEquals(expectedExamples, actualExamples);
    }
}
