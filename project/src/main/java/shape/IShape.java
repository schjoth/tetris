package shape;

import java.util.ArrayList;
import java.util.Arrays;

public class IShape extends Shape {
	
	private static final String color = "#00FFFF";
	
	public IShape(int columnLength) {
		super(color,
				new ArrayList<Integer>(Arrays.asList(-2, -1, 0, 1)),
				new ArrayList<Integer>(Arrays.asList(0, -columnLength, -2*columnLength, -3*columnLength)),
				new ArrayList<Integer>(Arrays.asList(-1, 0, 1, 2)),
				new ArrayList<Integer>(Arrays.asList(0, -columnLength, -2*columnLength, -3*columnLength))
		);
	}
}
