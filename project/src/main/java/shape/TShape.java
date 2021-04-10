package shape;

import java.util.ArrayList;
import java.util.Arrays;

public class TShape extends Shape{

	private static final String color = "BF00FF";

	public TShape (int columnLength) {
		super(color,
				new ArrayList<Integer>(Arrays.asList(-1, 0, -columnLength, + 1)),
				new ArrayList<Integer>(Arrays.asList(-columnLength, 0, 1, columnLength)),
				new ArrayList<Integer>(Arrays.asList(-1, 0, columnLength, + 1)),
				new ArrayList<Integer>(Arrays.asList(-columnLength, 0, -1, columnLength))
		);
	}
}
