package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import persistance.FileOperations;

public class HandleHighScores {
	
	private List<Map<String, String>> highscores = new ArrayList<>();
	
	
	// Fileoperations.readFromFile(); typ
	
	public HandleHighScores() {
		for (int i = 0; i < 5; i++) {
			Map<String, String> score1 = new HashMap<>();
			score1.put("name", "per");
			score1.put("score", ""+i);		
			highscores.add(score1);

		}
	}
	
	
	public List<Map<String, String>> updateScore(String name, int contenderScore) {
		Map<String, String> score = new HashMap<>();
		score.put("name", name);
		score.put("score", ""+ contenderScore); 
		highscores.add(score);
		highscores.sort((o1 , o2) -> Integer.valueOf(o1.get("score")) - Integer.valueOf(o2.get("score")));
		if (highscores.size() > 5) {
			highscores.remove(highscores.size()-1);			
		}
		return highscores;
	}
	
	public List<Map<String, String>> getHighScores() {
		return highscores;
		
	}
	
	public void saveHighScores() {
		try {
			FileOperations.writeToFile(highscores);
			System.out.println("Succecssssssscscscscsc");
		} catch (JsonGenerationException | JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
