package logic;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.databind.JsonMappingException;
import persistance.FileOperations;

public class HandleHighScores  {
	
	private FileOperations fileOperator = new FileOperations();
	private List<Score> highscores = new ArrayList<>();
	
	public HandleHighScores() {

	}
	
	public List<Score> updateScore(String name, int contenderScore, String path) {
		Score score = new Score(name, contenderScore);
		highscores.add(score);
		Collections.sort(highscores);
		if (highscores.size() > 5) {
			highscores.remove(highscores.size()-1);			
		}
		saveHighScores(path);
		return highscores;
	}
	
	public List<Score> getHighScores() {
		return highscores;	
	}
	
	public void saveHighScores(String path) {
		try {
			fileOperator.writeToFile(highscores, path);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		}
	}
	
	public void getHighScoresFromFile(String path) {
		highscores = fileOperator.readFromFile(path);
	}	
}
