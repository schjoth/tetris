package coordinatesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import coordinates.*;
import shape.Shape;
import shape.SquareShape;

public class CoordinatesTest {

	@Test
	public void CoordinateTest() {
		Coordinates coordinate = new Coordinates(5,8);
		assertEquals(5, coordinate.getX());
		assertEquals(8, coordinate.getY());
	}
	
	@Test
	public void getCoordinatesForShapeTest() {
		Shape square = new SquareShape(20);
		
		Collection<Coordinates> coordinates = Coordinates.getCoorinatesForShape(square, 4, 8, 20);
		
		assertNotNull(coordinates);		
	}
	
}