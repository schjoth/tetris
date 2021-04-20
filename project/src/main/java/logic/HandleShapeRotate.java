package logic;

import java.util.Collection; 
import java.util.stream.Collectors;
import coordinates.Coordinates;
import shape.Shape;

public class HandleShapeRotate {
	public static boolean tryRotateRight(Shape shape, Board board) {
		shape.rotateRight();
		boolean possible = checkIfSpaceForShape(shape, board);
		if (!possible) shape.rotateLeft();
		return possible;
	}
	
	public static boolean tryRotateLeft(Shape shape, Board board) {
		shape.rotateLeft();
		boolean possible = checkIfSpaceForShape(shape, board);
		if (!possible) shape.rotateRight();
		return possible;
	}
	
	private static boolean checkIfSpaceForShape(Shape shape, Board board) {
		int posX = board.getPosX();
		int posY = board.getPosY();
		
		Collection<Coordinates> positions = Coordinates.getCoorinatesForShape(shape, posX, posY, board.getColumnLength());		
		
		//finds all x-coordinates for the shape
		Collection<Integer> allColumnValues = positions.stream().map(Coordinates::getX).collect(Collectors.toList());
		
		//Checks if Shape tries is present on both left and right side of the board
		if (allColumnValues.contains(0) && allColumnValues.contains(board.getColumnLength()-1)) return false;
		
		//Checks if the tiles in the board are empty
		return positions.stream()
			.map(coo -> board.getTile(coo.getX(), coo.getY()) == null)
			.reduce((a,b) -> a || b)
			.get();
	}
}
