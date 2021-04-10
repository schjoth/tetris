package tetris;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AppController {
	
	@FXML private AnchorPane userPage;
    @FXML private AnchorPane gamePage;
    @FXML private Button handleStartGame;
    @FXML private TextField userNameField;
    @FXML private Label currentPlayerField;
	
    private String userName;
    
	@FXML
	public void handleStartGame() {
		System.out.println("Start game!");	
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
	}
}
