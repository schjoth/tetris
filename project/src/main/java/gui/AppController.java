package gui;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import coordinates.Coordinates;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.HandleHighScores;
import persistance.FileOperations;

public class AppController implements Initializable {
	
	@FXML private AnchorPane userPage;
    @FXML private AnchorPane gamePage;
	@FXML private AnchorPane activePane;
    @FXML private Button handleStartGame;
    @FXML private TextField userNameField;
    @FXML private Label currentPlayerField;
    @FXML private Label currentScore;
	@FXML private Label firstPlace;
	@FXML private Label secondPlace;
	@FXML private Label thirdPlace;
	@FXML private Label fourthPlace;
	@FXML private Label fifthPlace;
    
    private Coordinates currentPos;
    private String userName;
    private Boolean gameRunning;
    private int userScore;
    HandleHighScores highScoreHandler;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
		userPage.setDisable(false);
		userPage.setVisible(true);
		gamePage.setDisable(true);
		gamePage.setVisible(false);
    }
    
	@FXML
	public void userNameSubmit() {
		this.userName = userNameField.getText();
		userPage.setDisable(true);
		userPage.setVisible(false);
		gamePage.setDisable(false);
		gamePage.setVisible(true);
		System.out.println(userName);
		currentPlayerField.setText("CURRENT PLAYER: " + userName);
		highScoreHandler = new HandleHighScores();
		updateScores();
	}
    
	@FXML
	public void handleStartGame() {
		System.out.println("Start game!");
		gameRunning = true;
		userScore += 1; //Bare for å teste score-label intill videre.
		currentScore.setText(""+ userScore);
		highScoreHandler.saveHighScores();
		}
	
	@FXML
	public void updateScores() {
		List<Map<String, String>> newScores = highScoreHandler.getHighScores();
		firstPlace.setText(newScores.get(0).get("name")  + ": " + newScores.get(0).get("score"));
		secondPlace.setText(newScores.get(1).get("name")  + ": " + newScores.get(1).get("score"));
		thirdPlace.setText(newScores.get(2).get("name")  + ": " + newScores.get(2).get("score"));
		fourthPlace.setText(newScores.get(3).get("name")  + ": " + newScores.get(3).get("score"));
		fifthPlace.setText(newScores.get(4).get("name")  + ": " + newScores.get(4).get("score"));
        }
	
	@FXML
	public void deleteLines() {
		
	}
		
	@FXML
	public void moveRight() {
		
	}
	
	@FXML
	public void moveLeft() {
		
	}
	
	@FXML
	public void rotateShape() {
		
	}
	
	@FXML
	public void gameOver() {
		
	}
	
	
}
