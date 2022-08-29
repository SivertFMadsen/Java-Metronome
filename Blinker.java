import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Blinker implements ActionListener {

    Timer blinkTimer;
    GUI gui;
    JLabel beater;
    int blinkTime;
    // Determines for how long the beater will stay green

    public Blinker(GUI g, JLabel b) {
        gui = g;
        beater = b;
        blinkTime = 50;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        beater.setBackground(Color.GREEN);
        blinkTimer = new Timer(blinkTime, new ResetColor());
        blinkTimer.setRepeats(false);
        blinkTimer.start();
    }

    class ResetColor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            beater.setBackground(Color.RED);
        }
    }
}