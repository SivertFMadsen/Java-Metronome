import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {

    JFrame window;
    JPanel panel, visual, input;
    JLabel beater, BPMLabel;
    JTextField BPMField;
    JButton plus, minus, ss;
    Controller controller;
    int BPM;
    String lvBPM;
    Timer timer;
    // last valid BPM

    public GUI() {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.exit(9);
        }

        BPM = 100;

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

        // BPMLabel = new JLabel(Integer.toString(BPM));
        // BPMLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

        class TextField implements ActionListener {

            String BPMS;
            int BPMIn;

            @Override
            public void actionPerformed(ActionEvent e) {
                BPMS = BPMField.getText();
                if (!checkInput(BPMS)) {
                    BPMField.setText(lvBPM);
                } else {
                    lvBPM = BPMS;
                    BPMIn = Integer.parseInt(BPMS);
                    if (BPMIn > 1000) {
                        BPMIn = 1000;
                        BPMField.setText("1000");
                    } else if (BPMIn < 1) {
                        BPMIn = 1;
                        BPMField.setText("1");
                    }
                    controller.setBPM(BPMIn);
                }
            }
        }

        BPMField = new JTextField("100", 4);
        // TODO: finn ut hva dette er -> BPMField.setBounds() ?
        BPMField.addActionListener(new TextField());
        input.add(BPMField, BorderLayout.CENTER);


        class StartStop implements ActionListener {
            // Starts and stops the metronome, and changes the text on the button

            String BPMS;
            int BPMIn;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (ss.getText().equals("START")) {

                    BPMS = BPMField.getText();
                    if (!checkInput(BPMS)) {
                        BPMField.setText(lvBPM);
                    } else {
                        lvBPM = BPMS;
                        BPMIn = Integer.parseInt(BPMS);
                        if (BPMIn > 1000) {
                            BPMIn = 1000;
                            BPMField.setText("1000");
                        } else if (BPMIn < 1) {
                            BPMIn = 1;
                            BPMField.setText("1");
                        }
                        controller.setBPM(BPMIn);
                    }
                    // TODO: make sure BPM is set to a valid value
                    System.out.println("Metronome starts. Current BPM: " + BPM);
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

        /*  the following classes controls the blinking of the beater panel
        while the meteronome is running
        */

        // class ResetColor implements ActionListener {

        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         beater.setBackground(Color.RED);
        //     }
        // }

        // class Blinker implements ActionListener {

        //     Timer blinkTimer;
        //     int beats = 0;
        //     double BPMDelay;
        //     // this is temporary

        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         beats += 1;
        //         BPMDelay = 6000/BPM;
        //         if (beats%BPMDelay == 0) {
        //             beats = 0;
        //             System.out.println("beat");
        //             beater.setBackground(Color.GREEN);
        //             blinkTimer = new Timer(20, new ResetColor());
        //             blinkTimer.setRepeats(false);
        //             blinkTimer.start();
        //         }
        //     }
        // }

        // timer = new Timer(10, new Blinker());
        // timer.start();

        window.pack();
        window.setVisible(true);
    }

    public void setBPM(int newBPM) {
        BPMField.setText(Integer.toString(newBPM));
        BPM = newBPM;
    }

    public boolean checkInput(String inp) {

        try {
            Integer.parseInt(inp);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}