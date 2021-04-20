package logicTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import logic.Score;

public class ScoreTest {
	
	@Test
	public void TestScore() {
		Score testScore = new Score("Test", 69);
		
		assertEquals("Test", testScore.getName());
		assertEquals(69, testScore.getScore());
	}
	
	@Test
	public void TestCompareScore() {
		Score testScore1 = new Score("Test1", 44);
		
		int compareTest = testScore1.compareTo(new Score("Test2", 88));
		
		assertEquals(44, compareTest);
	}
	
}
