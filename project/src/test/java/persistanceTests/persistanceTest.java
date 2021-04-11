package persistanceTests;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import logic.HandleHighScores;
import logic.Score;

public class persistanceTest {
	

	@Test
	public void testReadingFromFile() {
		HandleHighScores handler = new HandleHighScores();
		List<Score> scores = handler.getHighScores();
		assertNotEquals(0, scores.size());
	}
}