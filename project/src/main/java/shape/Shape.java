package shape;

import java.util.Collection;

public interface Shape {

	/**
	 * Returns the color of the shape
	 * 
	 * @return color as hexadecimal
	 */
	public String getColor();
	
	/**
	 * 
	 * 
	 * @return
	 */
	public Collection<Integer> getShapeIndexes();
	
	public void rotateLeft();
	
	public void rotateRight();
}
