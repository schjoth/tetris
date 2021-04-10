package persistance;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileOperations {

	public static FileWriter file;
	
	
	public void readFromFile() {
		
	}
	
	public static void writeToFile(List<Map<String, String>> highscores) throws JsonGenerationException, JsonMappingException, IOException {
		// create object mapper instance
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.writeValue(Paths.get("src/main/resources/highscores.json").toFile(), highscores);
	}
}
