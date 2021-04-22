package logicTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import logic.Board;
import shape.Shape;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class BoardTest {
	private Board board;

	@BeforeEach
	public void setup() {
		board = new Board(10,20);
		board.insertNewBlock();
	}

	@Test
	public void testIllegalArguments() {
		assertThrows(IllegalArgumentException.class, () -> new Board(0, 1));
		assertThrows(IllegalArgumentException.class, () -> new Board(1, 0));
	}

	@Test
	public void testGetNextShape() {
		assertTrue(board.getNextShape() instanceof Shape);
	}

	@Test
	public void testMoveLeftAndRight() {
		int initialPosX = board.getPosX();
		assertTrue(board.moveRight());
		assertTrue(board.getPosX() == initialPosX + 1);
		assertTrue(board.moveLeft());
		assertTrue(board.getPosX() == initialPosX);
	}

	@Test
	public void testMoveDownAndHardDrop() {
		int initialPosY = board.getPosY();
		board.moveDown();
		assertTrue(board.getPosY() == initialPosY + 1);
		assertFalse(board.getTile(board.getPosX(), board.getPosY()) == null);
		board.hardDrop();
		assertTrue(board.getPosY() == initialPosY);
	}

	@Test
	public void testTilePlaced() {
		board.hardDrop();
		List<List<String>> gameBoard =  board.getBoard();
		assertTrue(gameBoard.stream()
			.anyMatch(list -> list.stream()
					.anyMatch(color -> color != null)));
	}

	@Test
	public void testRotate() {
		board.moveDown();
		board.moveDown();
		assertTrue(board.rotateShape());
	}

	@Test
	public void testGameOver() {
		int counter = 0;
		while (counter < board.getRowLength()) {
			board.hardDrop();
			counter++;
		}
		assertTrue(board.isGameOver());
	}

	@Test
	public void checkIfScoreUpdates() {
		assertTrue(board.getScore() == 0);
		board.moveDown();
		int scoreAfterMoveDown = board.getScore();
		assertTrue(scoreAfterMoveDown > 0);
		board.hardDrop();
		assertTrue(board.getScore() > scoreAfterMoveDown);
	}
	
	@Test
	public void testGetTile() {
		assertThrows(IllegalArgumentException.class, () -> board.getTile(-1,0));
		assertThrows(IllegalArgumentException.class, () -> board.getTile(0,-1));
		assertThrows(IllegalArgumentException.class, () -> board.getTile(0, board.getRowLength()));
		assertThrows(IllegalArgumentException.class, () -> board.getTile(board.getColumnLength(), 0));
		
		for (int i = 0; i < board.getRowLength(); i++) {
			for (int j = 0; j < board.getColumnLength(); j++) {
				int x = j;
				int y = i;
				assertDoesNotThrow(() -> board.getTile(x,y));
			}
		}
	}
}
