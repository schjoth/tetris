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
	private int score;
	
	//hver block blir representert ved fargen sin som en string
	private List<List<String>> board = new ArrayList<>();
	
	public Board(int columnLength, int rowLength) {
		startPosY = 0;
		startPosX = columnLength / 2;
		posX = startPosX;
		posY = startPosY;
		nextShape = NextShapeGenerator.getNextShape(columnLength);

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
		
		boolean spaceBelow = checkSpaceY(posY  + 1);
		
		if (!spaceBelow) {
			updatePlacement(false);
			insertNewBlock();
		} else {
			posY++;
		}
		updatePlacement(false);
	}
	
	public void hardDrop() {
		int i = posY;
		while (i < getRowLength()) {
			i++;
			if (!checkSpaceY(i)) {
				i--;
				break;
			}
		}
		posY = i;
		updatePlacement(false);
		insertNewBlock();
	}
	
	private Boolean checkSpaceY(int y) {
		try {
			updatePlacement(true);
			boolean spaceBelow = Coordinates.getCoorinatesForShape(currentShape, posX, y, getColumnLength()).stream()
				.map(coo -> getTile(coo.getX(), coo.getY()) == null || coo.getY() == getColumnLength())
				.reduce((a,b) -> a && b)
				.get();
			if (spaceBelow == false) throw new IllegalStateException();
		} catch (IndexOutOfBoundsException | IllegalStateException e) {
			return false;
		}
		return true;
	}
	
	
	private void updatePlacement(boolean deleteTrace) {
		Coordinates.getCoorinatesForShape(currentShape, posX, posY, getColumnLength())
			.forEach(coo -> board.get(coo.getY())
				.set(coo.getX(),
					deleteTrace ? null : currentShape.color));
	}
	
	
	public Shape getNextShape() {
		return nextShape;
	}
	
	public void insertNewBlock() {
		checkForClearedLines();
		posX = startPosX;
		posY = startPosY;
		currentShape = nextShape;
		nextShape = NextShapeGenerator.getNextShape(getColumnLength());
	}
	
	private void checkForClearedLines() {
		for (int i = 0; i > getRowLength(); i++) {
			List<String> row = board.get(i);
			if (row.stream().map(color -> color != null).reduce((b,c) -> b || c).get())  {
				//TODO remove line, and move everything one line down
				board.remove(i);
				
				List<String> list = new ArrayList<>();
				while (list.size() < getColumnLength()) {
					list.add(null);
				}
				board.add(0, list);
				
				score += 10;
			}
		}
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
	
	public int getScore() {
		return score;
	}
}
