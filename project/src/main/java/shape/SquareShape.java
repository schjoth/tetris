package shape;

import java.util.ArrayList;
import java.util.Arrays;

public class SquareShape extends Shape {
	
	private static final String color = "#FFD500";

	public SquareShape (int columnLength) {
		super(color,
				new ArrayList<Integer>(Arrays.asList(0, 1, columnLength, columnLength + 1)),
				new ArrayList<Integer>(Arrays.asList(0, 1, columnLength, columnLength + 1)),
				new ArrayList<Integer>(Arrays.asList(0, 1, columnLength, columnLength + 1)),
				new ArrayList<Integer>(Arrays.asList(0, 1, columnLength, columnLength + 1))
		);
	}
}
