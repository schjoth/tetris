package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import coordinates.Coordinates;
import coordinates.CoordinatesCalculator;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import logic.Board;
import logic.HandleHighScores;
import logic.Score;
import shape.IShape;
import shape.JShape;
import shape.LShape;
import shape.SShape;
import shape.Shape;
import shape.SquareShape;
import shape.TShape;
import shape.ZShape;

public class AppController implements Initializable {
	
	@FXML private AnchorPane userPage;
    @FXML private AnchorPane gamePage;
	@FXML private AnchorPane activePane;
	@FXML private GridPane gameGrid;
	@FXML private GridPane nextBlock;
    @FXML private Button handleStartGame;
    @FXML private TextField userNameField;
    @FXML private Label currentPlayerField;
    @FXML private Label currentScore;
	@FXML private Label firstPlace;
	@FXML private Label secondPlace;
	@FXML private Label thirdPlace;
	@FXML private Label fourthPlace;
	@FXML private Label fifthPlace;
	
    
//    private Coordinates currentPos;
	private Board board;
    private Boolean gameRunning;
    private String userName;
    private int userScore;
    HandleHighScores highScoreHandler;
    private Shape shape;
    
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
		board = new Board(10, 20);
		System.out.println("Start game!");
		highScoreHandler.saveHighScores("src/main/resources/highscores.json");
		gameRunning = true;
		currentScore.setText(""+ userScore);
		board.insertNewBlock();
		Timeline myTimeLine = new Timeline(new KeyFrame(Duration.seconds(0.5), ev -> {
        	board.moveDown();
        	updateGrid();
	       }));
		myTimeLine.setCycleCount(Animation.INDEFINITE);
	    myTimeLine.play();
	}		
	
	@FXML
	public void updateScores() {
		highScoreHandler.getHighScoresFromFile("src/main/resources/highscores.json");
		List<Score> newScores = highScoreHandler.getHighScores();
		System.out.println(newScores);
		
		firstPlace.setText(newScores.size() >= 1 ? newScores.get(0).getName()  + ": " + newScores.get(0).getScore() : "-");
		secondPlace.setText(newScores.size() >= 2 ? newScores.get(1).getName()  + ": " + newScores.get(1).getScore() : "-");
		thirdPlace.setText(newScores.size() >= 3 ? newScores.get(2).getName()  + ": " + newScores.get(2).getScore() : "-");
		fourthPlace.setText(newScores.size() >= 4 ? newScores.get(3).getName()  + ": " + newScores.get(3).getScore() : "-");
		fifthPlace.setText(newScores.size() >= 5 ? newScores.get(4).getName()  + ": " + newScores.get(4).getScore() : "-");
        }
	
	@FXML
	public void deleteLines() {
		
	}
		
	
	private void moveRight() {
		board.moveRight();
	}
	
	
	private void moveLeft() {
		board.moveLeft();
	}
	
	
	private void hardDrop() {
		board.hardDrop();
	}
	
	
	private void rotateShape() {
		
	}
	
	@FXML 
	public void handleKeyPressed(KeyEvent e) {
		System.out.println(e.getCode());
		if (e.getCode().equals(KeyCode.A)) {
			moveLeft();
			updateGrid();
		}
		if (e.getCode().equals(KeyCode.S)) {
			hardDrop();
			updateGrid();
		}
		if (e.getCode().equals(KeyCode.D)) {
			moveRight();
			updateGrid();
		}
		if (e.getCode().equals(KeyCode.W)) {
			rotateShape();
			updateGrid();
		} else {
			return;
		}

		updateGrid();
	}
	
	public void updateGrid() {
		gameGrid.getChildren().clear();
		for (int y = 0; y < gameGrid.getRowCount(); y++) {
			for (int x = 0; x < gameGrid.getColumnCount(); x++) {
				String color = board.getTile(x, y);
				StackPane pane = new StackPane();
				pane.setStyle("-fx-background-color: " + color);
				GridPane.setFillHeight(pane, true);
				GridPane.setFillWidth(pane, true);
				gameGrid.add(pane, x, y);				
			}
		}
		showNext();
	}
	
	@FXML
	public void showNext() {
		nextBlock.getChildren().clear();
		Shape shape = null;
		
		switch(board.getNextShape().color) {
		case JShape.color: shape = new JShape(nextBlock.getColumnCount()); break;
		case IShape.color: shape = new IShape(nextBlock.getColumnCount()); break;
		case SShape.color: shape = new SShape(nextBlock.getColumnCount()); break;
		case SquareShape.color: shape = new SquareShape(nextBlock.getColumnCount()); break;
		case TShape.color: shape = new TShape(nextBlock.getColumnCount()); break;
		case ZShape.color: shape = new ZShape(nextBlock.getColumnCount()); break;
		case LShape.color: shape = new LShape(nextBlock.getColumnCount()); break;
		}
		
		Collection<Integer> indexes = shape.getShapeIndexes();
		
		for (int index : indexes) {
			Coordinates nextCo = CoordinatesCalculator.calcuateCoordinates(index, nextBlock.getColumnCount());
			StackPane pane = new StackPane();
			pane.setStyle("-fx-background-color: " + board.getNextShape().color);
			GridPane.setFillHeight(pane, true);
			GridPane.setFillWidth(pane, true);
			nextBlock.add(pane, nextCo.getX() + 4, nextCo.getY() + 2);
		}
	}
	
	@FXML
	public void gameOver() {
		this.gameRunning = false;
	}
	
}
