package edu.disease.asn3;

/**
 * The Class NonInfectiousDisease.
 */
public class NonInfectiousDisease extends Disease{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the examples.
	 *
	 * @return the examples
	 */
	@Override
	String[] getExamples() {
		// TODO Auto-generated method stub
		return new String[] {
				"Diabetes",
	            "Heart Disease",
	            "Asthma",
	            "Cancer"
		};
	}

}
