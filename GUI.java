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
        window.setPreferredSize(new Dimension(640, 480));

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        window.add(panel);

        window.pack();
        window.setVisible(true);

        
    }
}