package shape;

import java.util.ArrayList;
import java.util.Arrays;

public class LShape extends Shape {
	
	private static final String color = "#FF971C";
	
	public LShape (int columnLength) {
		super(color,
			new ArrayList<Integer>(Arrays.asList(0, -columnLength, -2*columnLength, -2*columnLength-1)),
			new ArrayList<Integer>(Arrays.asList(0, -columnLength, -columnLength+1, -columnLength+2)),
			new ArrayList<Integer>(Arrays.asList(0, 1, 1-columnLength, 1-2*columnLength)),
			new ArrayList<Integer>(Arrays.asList(0, 1, 2, 2-columnLength))
		);
	}
}
