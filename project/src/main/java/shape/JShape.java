package shape;

import java.util.ArrayList;
import java.util.Arrays;

public class JShape extends Shape{

	public final static String color = "#0341AE";
	
	public JShape (int columnLength) {
		super(color,
			new ArrayList<Integer>(Arrays.asList(2*columnLength, columnLength, 0, 2*columnLength-1)),	
			new ArrayList<Integer>(Arrays.asList(0, -columnLength, -columnLength+1, -columnLength+2)),
			new ArrayList<Integer>(Arrays.asList(0, 1, 1-columnLength, 1-2*columnLength)),
			new ArrayList<Integer>(Arrays.asList(0, 1, 2, 2-columnLength)));	
	}
}
