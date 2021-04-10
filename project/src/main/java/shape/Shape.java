package shape;

import java.util.Collection;

public interface Shape {

	public String getColor();
	
	public Collection<Integer> getShapeIndexes();
	
	public void rotateLeft();
	
	public void rotateRight();
}
