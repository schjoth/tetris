package logicTests;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import logic.NextShapeGenerator;
import shape.Shape;

public class NextShapeGeneratorTest {

	@Test
	public void testRandomShapeGenerator() {
		Shape shape = NextShapeGenerator.getNextShape(10);
		assertNotEquals(null, shape);
	}
}
