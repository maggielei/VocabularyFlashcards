package APP;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import UI.VFUI;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        VFUI root = new VFUI();
        BorderPane startMenu = root.getStartMenu();
        primaryStage.setTitle("Vocabulary Flash Cards");
        Scene scene = new Scene(startMenu, startMenu.getWidth(), startMenu.getHeight());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
