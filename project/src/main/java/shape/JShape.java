package shape;

import java.util.ArrayList;
import java.util.Arrays;

public class JShape extends Shape{

	public final static String color = "#0341AE";
	
	public JShape (int columnLength) {
		super(color,
			new ArrayList<Integer>(Arrays.asList(0, columnLength, columnLength*2, columnLength*2-1)),	
			new ArrayList<Integer>(Arrays.asList(+1, 0, -1, -columnLength-1)),
			new ArrayList<Integer>(Arrays.asList(columnLength, 0, -columnLength, -columnLength+1)),
			new ArrayList<Integer>(Arrays.asList(-1, 0, +1, 1+columnLength)));	
	}
}
