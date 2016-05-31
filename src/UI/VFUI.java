package UI;

import APP.VocabularyFlashcards;
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
    private Button checkButton;
    private Label wordLabel;
    private TextField entryBox;

    private VBox buttonBox;
    private VBox gameBox;

    VocabularyFlashcards flashcards;

    public VFUI(){
        eventHandler = new VFEventHandler(this);
        initStartMenu();
    }
    // Start menu
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

    // Pressing 'Start'
    public void initGameScreen(){
        startMenu.getChildren().clear();
        flashcards = new VocabularyFlashcards();

        // Display the German word, a textfield for translation, a check button, and exit button
        final String randomWord = flashcards.generateRandomWord();
        gameBox = new VBox(5);
        wordLabel = new Label(randomWord);
        entryBox = new TextField();
        checkButton = new Button("Check");
        exitButton = new Button("Exit");

        gameBox.getChildren().addAll(wordLabel, entryBox, checkButton, exitButton);
        startMenu.setCenter(gameBox);

        // Check button event
        checkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String answer = entryBox.getText();
                System.out.println(answer);
                System.out.println(randomWord);
                eventHandler.checkAnswer(answer, randomWord);
            }
        });

        // Exit button event
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                eventHandler.exit();
            }
        });

    }

    public BorderPane getStartMenu(){
        return this.startMenu;
    }
}
