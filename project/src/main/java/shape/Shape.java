package shape;

import java.util.Collection;

public abstract class Shape {
	
	private String color;
	private String currentDirectionString;
	private Collection<Integer> currentDirection;
	private Collection<Integer> up;
	private Collection<Integer> right;
	private Collection<Integer> down;
	private Collection<Integer> left;

	public Shape (String color, 
			Collection<Integer> up,
			Collection<Integer> right,
			Collection<Integer> down,
			Collection<Integer> left) {
		this.color = color;
		this.up = up;
		this.right = right;
		this.down = down;
		this.left = left;
		this.currentDirection = this.up;
		this.currentDirectionString = "up";
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
			case "up": {
				currentDirection = this.left;
				currentDirectionString = "left";
			}
		
			case "left": {
				currentDirection = this.down;
				currentDirectionString = "down";
			}
			
			case "down": {
				currentDirection = this.right;
				currentDirectionString = "right";
			}
			
			case "right": {
				currentDirection = this.up;
				currentDirectionString = "up";
		}
	}
	};
	
	/**
	 * Changes the ShapeIndexes of the shape in order to rotate the object
	 */
	public void rotateRight() {
		switch (currentDirectionString) {
			case "up": {
				currentDirection = this.right;
				currentDirectionString = "right";
			}
		
			case "right": {
				currentDirection = this.down;
				currentDirectionString = "down";
			}
			
			case "down": {
				currentDirection = this.left;
				currentDirectionString = "left";
			}
			
			case "left": {
				currentDirection = this.up;
				currentDirectionString = "up";
			}
		}
	}
}
