package edu.disease.asn6;

import java.util.Arrays;
import java.util.List;


/**
 * The Class InfectiousDisease.
 * @author Saravanan Selvaraj
 * @version 1.0.0
 */
public class InfectiousDisease extends Disease {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the examples.
	 *
	 * @return the examples
	 */
	@Override
	List<String> getExamples() {
		// Provide concrete implementation and return a List<String>
		return Arrays.asList("Influenza", "Tuberculosis", "COVID-19", "Malaria");
	}
}
