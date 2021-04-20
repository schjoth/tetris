package logicTests;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import logic.HandleHighScores;
import logic.Score;

public class HandleHighScoresTest {
	
	@Test
	public void updateScores() {
		HandleHighScores handler = new HandleHighScores();
		handler.getHighScoresFromFile("src/test/resources/testScores.json");
		
		List<Score> scores = handler.getHighScores();
		handler.updateScore("test", scores.get(scores.size()-1).getScore() + 1, "src/test/resources/testScores.json");
		
		List<Score> newScores = handler.getHighScores();
		assertNotEquals(scores.toArray(), newScores.toArray());
	
	}
}
