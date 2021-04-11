package coordinates;

import java.util.Collection;
import java.util.stream.Collectors;

import shape.Shape;

public class Coordinates {
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public static Collection<Coordinates> getCoorinatesForShape(Shape shape, int posX, int posY, int columnLength) {
		int index = CoordinatesCalculator.calculateIndex(posX, posY, columnLength);
		return shape.getShapeIndexes().stream()
				.map(pos -> CoordinatesCalculator.calcuateCoordinates(pos + index, columnLength))
				.collect(Collectors.toList());
	}

}
