package logic;

import java.util.Random;

import shape.IShape;
import shape.JShape;
import shape.LShape;
import shape.SShape;
import shape.Shape;
import shape.SquareShape;
import shape.TShape;
import shape.ZShape;

public class NextShapeGenerator {
	public static Shape getNextShape() {
		Shape shape = null;
		
		int number = new Random().nextInt(7);
		switch (number) {
			case 0: shape = new IShape();
			case 1: shape = new JShape();
			case 2: shape = new LShape();
			case 3: shape = new SquareShape();
			case 4: shape = new SShape();
			case 5: shape = new TShape();
			case 6: shape = new ZShape();
		}
		return shape;
	}
}
