public class Controller {
    Model model;
    GUI gui;
    boolean isRunning;

    public Controller(GUI g) {
        gui = g;
        model = new Model(gui);
        isRunning = false;
    }

    public void updateBPM(int change) {
        model.changeBPM(change);
    }

    public void setBPM(int newBPM) {
        model.setBPM(newBPM);
    }

    public void changeState() {
        if (isRunning) {
            isRunning = false;
        } else {
            isRunning = true;
        }
    }
}