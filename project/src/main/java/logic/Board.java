package logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import coordinates.Coordinates;
import coordinates.CoordinatesCalculator;
import shape.Shape;

public class Board {
	
	private int posX, posY, startPosX, startPosY;
	private Shape currentShape;
	private Shape nextShape;
	
	//hver block blir representert ved fargen sin som en string
	private List<List<String>> board = new ArrayList<>();
	
	public Board(int columnLength, int rowLength) {
		startPosY = 0;
		startPosX = columnLength / 2;
		posX = startPosX;
		posY = startPosY;
		nextShape = NextShapeGenerator.getNextShape(getColumnLength());

		while (board.size() < rowLength) {
			List<String> list = new ArrayList<>();
			while (list.size() < columnLength) {
				list.add(null);
			}
			board.add(list);
		}
		
		System.out.println(board);
	}

	public void moveRight() {
		//TODO: valider
		updatePlacement(true);
		posX++;
		
		updatePlacement(false);
	}
	
	public void moveLeft() {
		//TODO: valider
		updatePlacement(true);
		posX--;
		updatePlacement(false);
	}
	
	public void moveDown() {
		boolean spaceBelow = Coordinates.getCoorinatesForShape(currentShape, posX, posY + 1, getColumnLength()).stream()
			.map(coo -> getTile(coo.getX(), coo.getY()) == null)
			.reduce((a,b) -> a || b)
			.get();
		
		if (posY == getRowLength() - 1 || !spaceBelow) {
			insertNewBlock();
		} else {
			updatePlacement(true);
			posY++;
		}
		updatePlacement(false);
	}
	
	public void hardDrop() {
		updatePlacement(true);
		int i = posY;
		while (i < getRowLength()) {
			i++;
			try {
				boolean spaceBelow = Coordinates.getCoorinatesForShape(currentShape, posX, i, getColumnLength()).stream()
					.map(coo -> getTile(coo.getX(), coo.getY()) == null)
					.reduce((a,b) -> a && b)
					.get();
				if (spaceBelow == false) throw new IllegalStateException();
			} catch (IndexOutOfBoundsException | IllegalStateException e) {
				i--;
				break;
			}
		}
		posY = i;
		updatePlacement(false);
		insertNewBlock();
	}
	
	private void updatePlacement(boolean deleteTrace) {
		Coordinates.getCoorinatesForShape(currentShape, posX, posY, getColumnLength())
			.forEach(coo -> board.get(coo.getY())
				.set(coo.getX(),
					deleteTrace ? null : currentShape.getColor()));
	}
	
	
	public Shape getNextShape() {
		return nextShape;
	}
	
	public void insertNewBlock() {
		posX = startPosX;
		posY = startPosY;
		currentShape = nextShape;
		nextShape = NextShapeGenerator.getNextShape(getColumnLength());
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
	
	public String getTile(int posX, int posY) {
		return board.get(posY).get(posX);
	}
	
	public List<List<String>> getBoard() {
		return board;
	}
}
