package edu.disease.asn1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
		System.out.print(exposureObj.toString());
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

}
