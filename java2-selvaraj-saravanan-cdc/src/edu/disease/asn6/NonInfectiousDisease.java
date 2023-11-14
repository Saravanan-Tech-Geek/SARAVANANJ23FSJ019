package edu.disease.asn6;

import java.util.Arrays;
import java.util.List;

public class NonInfectiousDisease extends Disease {

	private static final long serialVersionUID = 1L;

	@Override
	List<String> getExamples() {
		// Provide concrete implementation and return a List<String>
		return Arrays.asList("Diabetes", "Heart Disease", "Asthma", "Cancer");
	}

}
