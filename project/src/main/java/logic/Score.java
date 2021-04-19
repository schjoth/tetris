package logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Score implements Comparable<Score>{
	
	private String name;
	private int score;
	
	@JsonCreator
	public Score(@JsonProperty("name") String name, @JsonProperty("score") int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}

	@Override
	public int compareTo(Score o) {
		return o.score - this.score;
	}
}
