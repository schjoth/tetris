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
	public static Shape getNextShape(int columnLength) {
		Shape shape = null;
		
		int number = new Random().nextInt(7);
		switch (number) {
			case 0: shape = new IShape(columnLength); break;
			case 1: shape = new JShape(columnLength); break;
			case 2: shape = new LShape(columnLength); break;
			case 3: shape = new SquareShape(columnLength); break;
			case 4: shape = new SShape(columnLength); break;
			case 5: shape = new TShape(columnLength); break;
			case 6: shape = new ZShape(columnLength); break;
		}
		return shape;
	}
}
