package shape;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class Shape {
	
	private String color;
	private String currentDirectionString;
	private Map<String, Collection<Integer>> directions;
	private Collection<Integer> currentDirection;

	public Shape (String color, 
			Collection<Integer> up,
			Collection<Integer> right,
			Collection<Integer> down,
			Collection<Integer> left) {
		this.color = color;
		
		directions = new HashMap<>();
		directions.put("up", up);
		directions.put("right", right);
		directions.put("down", down);
		directions.put("left", left);
		
		currentDirectionString = "up";
		currentDirection = directions.get(currentDirectionString);
		
	}
	
	/**
	 * Returns the color of the shape
	 * 
	 * @return color as hexadecimal
	 */
	public String getColor() {
		return color;
	}
	
	
	/**
	 * Get the shapes as a collection of integers relative to the current index in the board
	 * 
	 * @return Collection of integers
	 */
	public Collection<Integer> getShapeIndexes(){
		return currentDirection;
	};
	
	
	/**
	 * Changes the ShapeIndexes of the shape in order to rotate the object
	 */
	public void rotateLeft() {
		switch (currentDirectionString) {
			case "up": currentDirectionString = "left";
			case "left": currentDirectionString = "down";
			case "down": currentDirectionString = "right";
			case "right": currentDirectionString = "up";
		}
		currentDirection = directions.get(currentDirectionString);
	};
	
	/**
	 * Changes the ShapeIndexes of the shape in order to rotate the object
	 */
	public void rotateRight() {
		switch (currentDirectionString) {
			case "up": currentDirectionString = "right";
			case "right": currentDirectionString = "down";
			case "down": currentDirectionString = "left";
			case "left": currentDirectionString = "up";	
		}
		currentDirection = directions.get(currentDirectionString);
	}
}
