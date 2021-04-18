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
	}
	
	public void moveRight() {
		moveRight(1);
	}

	public void moveRight(int distance ) {
		updatePlacement(true);
		
		boolean isSpaceAvailable = checkSpaceX(posX + distance);
		if (isSpaceAvailable) posX += distance;
		else {
			updatePlacement(false);
		};
		updatePlacement(false);
	}
	
	public void moveLeft() {
		moveLeft(1);
	}
	
	public void moveLeft(int distance) {
		updatePlacement(true);
		
		boolean isSpaceAvailable = checkSpaceX(posX - distance);
		if (isSpaceAvailable) posX -= distance;
		else {
			updatePlacement(false);
		};
		updatePlacement(false);
	}
	
	public void moveDown() {
		moveDown(1);
	}
	
	public void moveDown(int distance) {
		score += distance;
		
		updatePlacement(true);
		boolean spaceBelow = checkSpaceY(posY + distance);
		if (!spaceBelow) {
			updatePlacement(false);
			insertNewBlock();
		} else {
			posY += distance;
		}
		updatePlacement(false);
	}
	
	public void hardDrop() {
		updatePlacement(true);
		int i = posY;
		while (i < getRowLength()) {
			i++;
			if (!checkSpaceY(i)) {
				i--;
				break;
			}
		}
		score += (i - posY) * 10;
		
		posY = i;
		updatePlacement(false);
		insertNewBlock();
	}
	
	private Boolean checkSpaceY(int y) {
		try {
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
	
	private Boolean checkSpaceX(int x) {
		try {
			Collection<Coordinates> allCoordinates = Coordinates.getCoorinatesForShape(currentShape, x, posY, getColumnLength());
			
			boolean isSpaceAvailable = allCoordinates.stream()
				.map(coo -> 
					getTile(coo.getX(), coo.getY()) == null)
				.reduce((a,b) -> a && b)
				.get();
			
			Collection<Integer> xValues = allCoordinates.stream().map(Coordinates::getX).collect(Collectors.toList());
			boolean presentInBothBorders = xValues.contains(0) && xValues.contains(getColumnLength() - 1);
					
			if (isSpaceAvailable == false || presentInBothBorders) throw new IllegalStateException();
		} catch (IndexOutOfBoundsException | IllegalStateException e) {
			return false;
		}
		return true;
	}
	
	
	private void updatePlacement(boolean deleteTrace) {
		try {
		Coordinates.getCoorinatesForShape(currentShape, posX, posY, getColumnLength())
			.forEach(coo -> board.get(coo.getY())
				.set(coo.getX(),
					deleteTrace ? null : currentShape.color));
		} catch (IndexOutOfBoundsException e) {
			
		}
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
		int numberOfClearedLines = 0;
		for (int i = 0; i < getRowLength(); i++) {
			List<String> row = board.get(i);
			if (row.stream().map(color -> color != null).reduce((b,c) -> b && c).get())  {
				board.remove(i);
				
				List<String> list = new ArrayList<>();
				while (list.size() < getColumnLength()) {
					list.add(null);
				}
				board.add(0, list);
				
				numberOfClearedLines++;
				score += numberOfClearedLines * 100;
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

	public void rotateShape() {
		updatePlacement(true);
		try { 
			currentShape.rotateRight();
			updatePlacement(false);
		} catch (IndexOutOfBoundsException e) {
			if (checkSpaceX(posX + 1)) {
				moveRight();
				System.out.println("moveRight(1)");
			} else if (checkSpaceX(posX + 2)) {
				moveRight(2);
				System.out.println("moveRight(2)");
			} else if (checkSpaceX(posX - 1)) {
				moveLeft();
				System.out.println("moveLeft(1)");
			} else if (checkSpaceX(posX - 2)) {
				moveLeft(2);
				System.out.println("moveLeft(2)");
			} else if(checkSpaceY(posY + 1)) {
				moveDown();
				System.out.println("moveDown(1)");
			} else if(checkSpaceY(posY + 2)) {
				moveDown(2);
				System.out.println("moveDown(2)");
			} else {
				currentShape.rotateLeft();
				updatePlacement(false);
			}
		}
	}
}
