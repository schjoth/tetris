package persistanceTests;

import java.util.List;  
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import logic.HandleHighScores;
import logic.Score;

public class PersistanceTest {

	@Test
	public void writeToFile() {

		HandleHighScores handler = new HandleHighScores();
		handler.updateScore("Test", 69, "src/test/resources/testScores.json");
		List<Score> score1 = handler.getHighScores();
		assertTrue(score1.size() > 0);
	}


	@Test
	public void readFromFile() {
		
		HandleHighScores handler = new HandleHighScores();
		handler.updateScore("Test", 420, "src/test/resources/testScores.json");
		handler.getHighScoresFromFile("src/test/resources/testScores.json");
		List<Score> scores = handler.getHighScores();
		assertFalse(scores.size() == 0);
	}
	
	@Test
	public void readFromEmptyFile() {
		HandleHighScores handler = new HandleHighScores();
		handler.getHighScoresFromFile("src/test/resources/EmptyTestScore.json");
		List<Score> scores = handler.getHighScores();
		assertTrue(scores != null);
		assertTrue(scores.size() == 0);
	}
}