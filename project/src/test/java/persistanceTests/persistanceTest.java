package persistanceTests;

import java.util.List; 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import logic.HandleHighScores;
import logic.Score;

public class persistanceTest {

	@Test
	public void writeToFile() {

		HandleHighScores handler = new HandleHighScores();
		handler.updateScore("Test", 69, "src/test/resources/testScores.json");
		List<Score> score1 = handler.getHighScores();
		assertEquals(score1.get(0).getName(), "Test");
	}


	@Test
	public void readFromFile() {
		
		HandleHighScores handler = new HandleHighScores();
		handler.updateScore("Test", 420, "src/test/resources/testScores.json");
		handler.getHighScoresFromFile("src/test/resources/testScores.json");
		List<Score> scores = handler.getHighScores();
		assertNotEquals(0, scores.size());
	}
}