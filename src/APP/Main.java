package APP;

import javafx.application.Application;
import javafx.scene.Scene;
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
