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
