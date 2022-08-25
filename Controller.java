public class Controller {
    Model model;
    GUI gui;

    public Controller(GUI g) {
        gui = g;
        model = new Model(gui);
    }

    public void updateBPM(int change) {
        model.changeBPM(change);
    }
}
