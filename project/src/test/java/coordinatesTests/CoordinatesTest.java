package coordinatesTests;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import org.junit.jupiter.api.Test;

import coordinates.*;

public class CoordinatesTest {
	
	@Test
	public void testCalculateCoordinates() {
		int index = 1;
		int columnLength = 8;
		Coordinates coo1 = CoordinatesCalculator.calcuateCoordinates(index, columnLength);
		assertEquals(0, coo1.getY());
		assertEquals(1, coo1.getX());
		
		int index2 = 46;
		Coordinates coo2 = CoordinatesCalculator.calcuateCoordinates(index2, columnLength);
		assertEquals(5, coo2.getY());
		assertEquals(6, coo2.getX());
	}
	
	@Test
	public void testCalculateIndex() {
		int x = 3;
		int y = 5;
		int columnLength = 10;
		assertEquals(53, CoordinatesCalculator.calculateIndex(x, y, columnLength));
	}
}
