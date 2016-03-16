package UI;

import javafx.application.Platform;

public class VFEventHandler {
    private VFUI ui;
    
    public VFEventHandler(VFUI initUI){
        ui = initUI;
    }
    public void startPractice(){
        ui.initGameScreen();
    }
    public void exit(){
        Platform.exit();
    }
}
