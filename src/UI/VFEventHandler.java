package UI;

public class VFEventHandler {
    private VFUI ui;

    public VFEventHandler(VFUI initUI){
        ui = initUI;
    }
    public void startPractice(){
        ui.initGameScreen();
    }
    public void exit(){
        System.exit(0);
    }
}
