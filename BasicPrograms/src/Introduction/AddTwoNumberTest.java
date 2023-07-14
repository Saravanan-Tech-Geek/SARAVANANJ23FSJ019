package Introduction;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTwoNumberTest {

	@Test
	public void testAddWithPositiveValue() {
		AddTwoNumber obj = new AddTwoNumber();
		int firstNumber = 5;
		int secondNumber = 10;
		int result = obj.add(firstNumber,secondNumber);
		assertEquals(15, result);
	}

	@Test
	public void testAddWithNegativeValue() {
		AddTwoNumber obj = new AddTwoNumber();
		int result = obj.add(-5, -10);
		assertEquals(-15, result);
	}

	@Test
	public void testAddWithOnePositiveAndOneNegativeValue() {
		AddTwoNumber obj = new AddTwoNumber();
		int result = obj.add(20, -10);
		assertEquals(10, result);
	}
}
