package edu.disease.asn6;

import java.util.Arrays;
import java.util.List;

public class InfectiousDisease extends Disease {

	private static final long serialVersionUID = 1L;

	@Override
	List<String> getExamples() {
		// Provide concrete implementation and return a List<String>
		return Arrays.asList("Influenza", "Tuberculosis", "COVID-19", "Malaria");
	}
}
