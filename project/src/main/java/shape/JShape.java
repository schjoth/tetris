package shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class JShape implements Shape{

	private final String color = "#0341AE";
	private Collection<Integer> up;
	private Collection<Integer> right;
	private Collection<Integer> down;
	private Collection<Integer> left;
	
	public JShape (int columnLength) {
		this.up = new ArrayList<Integer>(Arrays.asList(0, -columnLength, -2*columnLength, -2*columnLength-1));
		this.right = new ArrayList<Integer>(Arrays.asList(0, -columnLength, -columnLength+1, -columnLength+2));
	}
	
	@Override
	public String getColor() {
		return color;
	}

	@Override
	public Collection<Integer> getShapeIndexes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rotateLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotateRight() {
		// TODO Auto-generated method stub
		
	}
}
