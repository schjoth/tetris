package shape;

import java.util.ArrayList;
import java.util.Arrays;

public class SShape extends Shape {
	
	public static final String color = "#72CB3B";

	public SShape (int columnLength) {
		super(color,
				new ArrayList<Integer>(Arrays.asList(0, 1, columnLength, columnLength - 1)),
				new ArrayList<Integer>(Arrays.asList(0, columnLength, columnLength + 1, columnLength * 2 + 1)),
				new ArrayList<Integer>(Arrays.asList(0, 1, columnLength, columnLength - 1)),
				new ArrayList<Integer>(Arrays.asList(0, columnLength, columnLength + 1, columnLength * 2 + 1))
		);
	}
}
