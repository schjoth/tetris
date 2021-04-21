package persistance;

import java.util.List;
import com.fasterxml.jackson.databind.JsonMappingException;
import logic.Score;

public interface FileOperationInterface {

	
	public List<Score> readFromFile(String path);
	
	public void writeToFile(List<Score> highscores, String path) throws JsonMappingException;	
	
}
