import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {

    JFrame window;
    JPanel panel, visual, input;
    JLabel beater, BPMLabel;
    JButton plus, minus, ss;
    int BPM;
    Controller controller;


    public GUI() {

        BPM = 100;

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

        visual = new JPanel();
        visual.setLayout(new BorderLayout());
        panel.add(visual, BorderLayout.NORTH);

        beater = new JLabel(" ");
        beater.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        beater.setOpaque(true);
        beater.setBackground(Color.RED);
        visual.add(beater, BorderLayout.CENTER);
        // TODO: fix size

        input = new JPanel();
        input.setLayout(new BorderLayout());
        window.add(input, BorderLayout.SOUTH);
        // TODO: switch to grid?

        // Initializes controller
        controller = new Controller(this);

        class ChangeBPM implements ActionListener {
            int change;

            public ChangeBPM(int c) {
                change = c;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.updateBPM(change);
            }
        }

        plus = new JButton("+");
        plus.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        plus.addActionListener(new ChangeBPM(1));
        input.add(plus, BorderLayout.EAST);

        minus = new JButton("-");
        minus.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        minus.addActionListener(new ChangeBPM(-1));
        input.add(minus, BorderLayout.WEST);

        BPMLabel = new JLabel(Integer.toString(BPM));
        // TODO: text should be based on current BPM
        BPMLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        input.add(BPMLabel, BorderLayout.CENTER);

        class StartStop implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (ss.getText().equals("START")) {
                    System.out.println("Metronome starts.");
                    ss.setText("STOP");
                    // TODO: notify controller to start metronome
                } else {
                    System.out.println("Metronome stops.");
                    ss.setText("START");
                    // TODO: notify controller to stop metronome
                }
            }
        }

        ss = new JButton("START");
        ss.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        ss.addActionListener(new StartStop());
        input.add(ss, BorderLayout.SOUTH);


        window.pack();
        window.setVisible(true);

    }

    public void setBPM(int newBPM) {
        BPMLabel.setText(Integer.toString(newBPM));
    }

}