import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {

    JFrame window;
    JPanel panel;


    public GUI() {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.exit(9);
        }

        // Initializes window
        window = new JFrame("Simple Metronome");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());



    }
}