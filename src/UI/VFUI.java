package UI;

import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class VFUI extends Pane{
    private VFEventHandler eventHandler;
    private BorderPane startMenu;
    private Insets marginlessInsets;
    private Button startButton;
    private Button exitButton;
    private VBox buttonBox;

    public VFUI(){
        eventHandler = new VFEventHandler(this);
        initStartMenu();
    }
    public void initStartMenu(){
        marginlessInsets = new Insets(5, 5, 5, 5);
        startMenu = new BorderPane();
        startMenu.resize(600, 500);
        startMenu.setPadding(marginlessInsets);

        buttonBox = new VBox(5);
        startButton = new Button("Start");
        exitButton = new Button("Exit");
        startButton.setMaxWidth(100);
        exitButton.setMaxWidth(100);

        buttonBox.getChildren().addAll(startButton, exitButton);
        buttonBox.setAlignment(Pos.CENTER);
        startMenu.setCenter(buttonBox);

        startButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                eventHandler.startPractice();
            }
        });
        exitButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                eventHandler.exit();
            }
        });
    }
    
    public void initGameScreen(){
        
    }

    public BorderPane getStartMenu(){
        return this.startMenu;
    }
}
