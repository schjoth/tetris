package persistance;

import java.io.FileWriter; 
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import logic.Score;

public class FileOperations {

	public static FileWriter file;
	
	
	public static List<Score> readFromFile(String path) {
		List<Score> highscores = new ArrayList<Score>();
		try {
		    // create object mapper instance
		    ObjectMapper mapper = new ObjectMapper();

		    // convert JSON file to map
		    highscores = Arrays.asList(mapper.readValue(Paths.get(path).toFile(), Score[].class));

		    // print map entriess
	    	System.out.println("Top 5 scores: ");
		    for (Score entry : highscores) {
		        System.out.println(entry.getName() + " = " + entry.getScore());
		    }

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		return highscores;
	}
	
	public static void writeToFile(List<Score> highscores) throws JsonMappingException {
		// create object mapper instance
	    ObjectMapper mapper = new ObjectMapper();
	    try {
			mapper.writeValue(Paths.get("src/main/resources/highscores.json").toFile(), highscores);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
