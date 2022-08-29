import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Model {
    int BPM;
    boolean isRunning;
    GUI gui;

    public Model(GUI g) {
        // default BPM value at startup
        BPM = 100;
        gui = g;
        isRunning = false;
    }

    public int getBPM() {
        return BPM;
    }

    public void changeBPM(int change) {
        BPM += change;
        gui.setBPM(BPM);
    }

    public void setBPM(int newBPM) {
        BPM = newBPM;
        gui.setBPM(BPM);
    }

    public void changeState() {
        if (isRunning) {
            isRunning = false;
            gui.stop();
        } else {
            isRunning = true;
            gui.run();
        }
    }

    public boolean running() {
        return isRunning;
    }
}
