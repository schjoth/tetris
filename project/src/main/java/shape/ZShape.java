package shape;

import java.util.ArrayList;
import java.util.Arrays;

public class ZShape extends Shape {

	private static final String color = "#FF3113";

	public ZShape (int columnLength) {
		super(color,
				new ArrayList<Integer>(Arrays.asList(-1, 0, columnLength, columnLength + 1)),
				new ArrayList<Integer>(Arrays.asList(0, columnLength, columnLength - 1, columnLength * 2 - 1)),
				new ArrayList<Integer>(Arrays.asList(-1, 0, columnLength, columnLength + 1)),
				new ArrayList<Integer>(Arrays.asList(0, columnLength, columnLength - 1, columnLength * 2 - 1))
		);
	}
}
