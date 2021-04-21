package coordinates;

import java.util.Collection;
import java.util.stream.Collectors;

import shape.Shape;

public class Coordinates {
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
	
	public static Collection<Coordinates> getCoorinatesForShape(Shape shape, int posX, int posY, int columnLength) {
		int index = CoordinatesCalculator.calculateIndex(posX, posY, columnLength);
		return shape.getShapeIndexes().stream()
				.map(pos -> CoordinatesCalculator.calcuateCoordinates(pos + index, columnLength))
				.collect(Collectors.toList());
	}

}
