import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Controller {
    Model model;
    GUI gui;

    public Controller(GUI g) {
        gui = g;
        model = new Model(gui);
    }

    // public void updateBPM(int change) {
    //     model.changeBPM(change);
    // }

    public void setBPM(int newBPM) {
        model.setBPM(newBPM);
    }

    public void changeState() {
        model.changeState();
    }
}