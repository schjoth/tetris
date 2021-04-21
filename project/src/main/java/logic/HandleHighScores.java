package logic;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.databind.JsonMappingException;
import persistance.FileOperations;

public class HandleHighScores  {
	
	private FileOperations fileOperator = new FileOperations();
	private List<Score> highscores = new ArrayList<>();
	
	/**
	 * Først lager man et Score objekt med navn og score gitt som parametere.
	 * Denne scoren blir lagt til i highscoreslisten, og så sorterer man listen i synkende rekkefølge.
	 * Dersom listen inneholder mer enn 5 scores, vil den bakerste, altså den minste scoren fjernes.
	 * Deretter skrives dette til filen med path gitt som parameter.
	 * 
	 * @param name
	 * @param contenderScore
	 * @param path
	 * @return
	 */
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
	
	
	/**
	 * Returnerer en liste med score-objekter.
	 * 
	 * @return
	 */
	public List<Score> getHighScores() {
		return highscores;	
	}
	
	
	/**
	 * Her bruker vi en fil-operator til å lagre highscores-listen til filen med path gitt som parameter.
	 * 
	 * @param path
	 */
	public void saveHighScores(String path) {
		try {
			fileOperator.writeToFile(highscores, path);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Henter highscores fra fil med path gitt som parameter, og overskriver highscores-listen med verdiene fra fil.
	 * 
	 * @param path
	 */
	public void getHighScoresFromFile(String path) {
		highscores = fileOperator.readFromFile(path);
	}	
}
