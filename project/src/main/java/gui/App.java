package gui;

import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = (Parent) fxmlLoader.load(this.getClass().getResourceAsStream("/App.fxml"));
        primaryStage.setTitle("Tetris");
        Scene scene = new Scene(root, 621, 530);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}
