package shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class IShape implements Shape {
	
	private final String color = "#00FFFF";
	private Collection<Integer> currentDirection; 
	private Collection<Integer> horizontal;
	private Collection<Integer> vertical;

	
	public IShape(int columnLength) {
		this.horizontal = new ArrayList<Integer>(Arrays.asList(-2, -1, 0, 1));
		this.vertical = new ArrayList<Integer>(Arrays.asList(0, -columnLength, -2*columnLength, -3*columnLength));
		this.currentDirection = this.vertical;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public Collection<Integer> getShapeIndexes() {
		return currentDirection;
	}

	@Override
	public void rotateLeft() {
		this.currentDirection = this.currentDirection == vertical ? horizontal : vertical;
	}

	@Override
	public void rotateRight() {
		this.rotateLeft();
	}
}
