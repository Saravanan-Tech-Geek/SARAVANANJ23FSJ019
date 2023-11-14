package edu.disease.asn6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class InfectiousDiseaseTest {

    @Test
    void testGetExamples() {
        InfectiousDisease infectiousDisease = new InfectiousDisease();

        List<String> expectedExamples = List.of("Influenza", "Tuberculosis", "COVID-19", "Malaria");
        List<String> actualExamples = infectiousDisease.getExamples();

        assertEquals(expectedExamples, actualExamples);
    }
}
