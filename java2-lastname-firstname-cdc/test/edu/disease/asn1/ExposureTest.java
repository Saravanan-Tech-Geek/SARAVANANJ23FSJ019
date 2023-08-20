package edu.disease.asn1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.Test;

import edu.disease.asn1.constants.ExposureConstants;
import exception.UnknownExposureTypeException;

public class ExposureTest {

	@Test
	public void testExposureConstructorAndGetters() {

		LocalDateTime datetime = LocalDateTime.now();
		UUID patientId = UUID.randomUUID();
		String exposureType = ExposureConstants.DIRECT_EXPOSURE;
		Exposure exposureObj = new Exposure(datetime, patientId, exposureType);
		assertEquals(datetime, exposureObj.getDateTime());
		assertEquals(patientId, exposureObj.getPatientId());
		assertEquals(exposureType, exposureObj.getExposureType());
	}

	@Test
	public void testExposureTypeValid() {
		LocalDateTime datetime = LocalDateTime.now();
		UUID patientId = UUID.randomUUID();
		String exposureType = ExposureConstants.DIRECT_EXPOSURE;
		Exposure exposureObj = new Exposure(datetime, patientId, "");
		exposureObj.setExposureType(exposureType);
		assertEquals(exposureType, exposureObj.getExposureType());
	}

	@Test(expected = UnknownExposureTypeException.class)
	public void testExposureTypeInValid() {
		LocalDateTime datetime = LocalDateTime.now();
		UUID patientId = UUID.randomUUID();
		String exposureType = "Invalid Exposure Type";
		Exposure exposureObj = new Exposure(datetime, patientId, "");
		exposureObj.setExposureType(exposureType);
	}

	@Test
	public void testSetDateTime() {
		LocalDateTime datetime1 = LocalDateTime.now();
		Exposure exposure = new Exposure(datetime1, null, null);
		exposure.setDateTime(datetime1);
		assertEquals(datetime1, exposure.getDateTime());
	}

	@Test
	public void testSetPatientId() {
		UUID patientId = UUID.randomUUID();
		Exposure exposure = new Exposure(null, patientId, null);
		exposure.setPatientId(patientId);
		assertEquals(patientId, exposure.getPatientId());
	}

	@Test
	public void testEqualsAndHashMethod() {
		LocalDateTime datetime1 = LocalDateTime.now();
		UUID patientId1 = UUID.randomUUID();
		String exposureType1 = ExposureConstants.DIRECT_EXPOSURE;
		Exposure exposure1 = new Exposure(datetime1, patientId1, exposureType1);

		LocalDateTime datetime2 = LocalDateTime.now();
		UUID patientId2 = UUID.randomUUID();
		String exposureType2 = ExposureConstants.INDIRECT_EXPOSURE;
		Exposure exposure2 = new Exposure(datetime2, patientId2, exposureType2);

		assertTrue(exposure1.equals(exposure1));
		assertFalse(exposure1.equals(exposure2));
		assertNotEquals(exposure1.hashCode(), exposure2.hashCode());
	}

	@Test
	public void testEqualsWithNull() {
		// Create an instance of Exposure
		Exposure exposure = new Exposure(null, null, null);
		exposure.setDateTime(LocalDateTime.now());
		exposure.setPatientId(UUID.randomUUID());

		// Call equals with null object
		boolean result = exposure.equals(null);

		// Assert that the result is false
		assertFalse(result);
	}

	@Test
	public void testEqualsWithDifferentClass() {
		Exposure exposure = new Exposure(null, null, null);
		exposure.setDateTime(LocalDateTime.now());
		exposure.setPatientId(UUID.randomUUID());

		// Create an object of a different class
		Object differentObject = new Object();

		// Call equals with the different object
		boolean result = exposure.equals(differentObject);

		// Assert that the result is false
		assertFalse(result);
	}

	@Test
	public void testToString() {
		LocalDateTime dateTime = LocalDateTime.now();
		UUID patientId = UUID.randomUUID();
		String exposureType = ExposureConstants.DIRECT_EXPOSURE;
		Exposure exposure = new Exposure(dateTime, patientId, exposureType);
		String expected = "Exposure [dateTime=" + dateTime + ", patientId=" + patientId + ", exposureType=" + exposureType + "]";
		assertEquals(expected, exposure.toString());
	}
}
