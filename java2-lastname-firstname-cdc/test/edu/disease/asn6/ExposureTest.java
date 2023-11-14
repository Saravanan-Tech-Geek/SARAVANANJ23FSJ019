package edu.disease.asn6;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.disease.asn1.Exposure;
import edu.disease.asn1.constants.ExposureConstants;
import exception.UnknownExposureTypeException;

import java.time.LocalDateTime;
import java.util.UUID;

class ExposureTest {

    private Exposure exposure;

    @BeforeEach
    void setUp() {
        exposure = new Exposure(LocalDateTime.now(), UUID.randomUUID(), ExposureConstants.DIRECT_EXPOSURE);
    }

    @Test
    void testSetAndGetDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        exposure.setDateTime(dateTime);
        assertEquals(dateTime, exposure.getDateTime());
    }

    @Test
    void testSetAndGetPatientId() {
        UUID patientId = UUID.randomUUID();
        exposure.setPatientId(patientId);
        assertEquals(patientId, exposure.getPatientId());
    }

    @Test
    void testSetAndGetExposureType() {
        exposure.setExposureType(ExposureConstants.INDIRECT_EXPOSURE);
        assertEquals(ExposureConstants.INDIRECT_EXPOSURE, exposure.getExposureType());
    }

    @Test
    void testSetExposureTypeWithUnknownType() {
        // Ensure that setting an unknown exposure type throws UnknownExposureTypeException
        assertThrows(UnknownExposureTypeException.class, () -> exposure.setExposureType("UnknownType"));
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
    void testToString() {
        String expectedString = "Exposure [dateTime=" + exposure.getDateTime() + ", patientId=" + exposure.getPatientId()
                + ", exposureType=" + exposure.getExposureType() + "]";
        assertEquals(expectedString, exposure.toString());
    }
}
