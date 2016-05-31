package UI;

import APP.VocabularyFlashcards;

public class VFEventHandler {
    private VFUI ui;
    private VocabularyFlashcards flashcards = new VocabularyFlashcards();

    public VFEventHandler(VFUI initUI){
        ui = initUI;
    }
    public void startPractice(){
        ui.initGameScreen();
    }
    public void checkAnswer(String Eng, String Ger) {
        flashcards.checkAnswer(Eng, Ger);
    }
    public void exit(){
        System.exit(0);
    }
}
