package logic;

import java.util.ArrayList;
import java.util.List;

import shape.Shape;

public class Board {
	
	private int posX, posY, startPosX, startPosY;
	
	//hver block blir representert ved fargen sin som en string
	private List<List<String>> board = new ArrayList<>();
	
	public Board(int columnLength, int rowLength) {
		startPosY = 0;
		startPosX = columnLength / 2;
		posX = startPosX;
		posY = startPosY;
		
		while (board.size() < rowLength) {
			List<String> list = new ArrayList<>();
			while (list.size() < columnLength) {
				list.add(null);
			}
			board.add(list);
		}
		
		System.out.println(board);
	}

	/*	
	for (index : getShapeIndexes()) {
		Coordinates coo = CoordinatesCalculator(CoordinatesCalcuator.calulateIndex(currenctPos) + index);
		GridPane.add(coo.getX())
	}
	*/
	
	public void moveRight() {
		posX++;
	}
	
	public void moveLeft() {
		posX--;
	}
	
	public void moveDown() {
		//TODO sjekk om den treffer noe under
		posY++;
	}
	
	public void insertNewBlock(Shape shape) {
		posX = startPosX;
		posY = startPosY;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getColumnLength() {
		return board.get(0).size();
	}
	
	public int getRowLength() {
		return board.size();
	}
}
