package persistanceTests;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import logic.HandleHighScores;
import logic.Score;

public class persistanceTest {

	@Test
	public void writeToFile() {

		HandleHighScores handler = new HandleHighScores();
		List<Score> score1 = handler.getHighScores();
		handler.updateScore("Test", 69);
		List<Score> score2 = handler.getHighScores();
		assertNotEquals(score1, score2);
	}


	@Test
	public void readFromFile() {
		
		HandleHighScores handler = new HandleHighScores();
		handler.getHighScoresFromFile("src/test/resources/testScores.json");
		List<Score> scores = handler.getHighScores();
		assertNotEquals(0, scores.size());
	}
	
}