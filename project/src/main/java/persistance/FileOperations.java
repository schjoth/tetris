package persistance;

import java.io.FileWriter; 
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import logic.Score;

public class FileOperations implements FileOperationInterface {

	public static FileWriter file;
	
	
	/**
	 *  Opretter en liste med score-objekter.
	 *  Bruker en ObjectMapper til å hente ut json fra fil med path gitt som parameter.
	 *  Legger disse verdiene inn i highscores-lista, og returnerer denne.
	 * 
	 * @param path
	 * @return 
	 * 
	 */
	public List<Score> readFromFile(String path) {
		List<Score> highscores = null;
		try {
		    // create object mapper instance
		    ObjectMapper mapper = new ObjectMapper();

		    // convert JSON file to map
		    highscores = new ArrayList<>(Arrays.asList(mapper.readValue(Paths.get(path).toFile(), Score[].class)));

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		return highscores;
	}
	
	/**
	 * Bruker en ObjectMapper til å skrive verdiene i highscores-listen til fil med path gitt som parameter.
	 * 
	 * @param highscores
	 * @param path
	 * 
	 */
	
	public void writeToFile(List<Score> highscores, String path) throws JsonMappingException {
		// create object mapper instance
	    ObjectMapper mapper = new ObjectMapper();
	    try {
			mapper.writeValue(Paths.get(path).toFile(), highscores);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
