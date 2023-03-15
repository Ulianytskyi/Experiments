package LifeOfCells;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StarrySky extends JFrame implements ActionListener {
    private final int WIDTH = 1024;
    private final int HEIGHT = 768;
    private final JButton showButton;
    private final JButton stopButton;
    private boolean showStars = false;
    private final Timer timer;

    public StarrySky() {
        super("Starry Sky");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        showButton = new JButton("Show Stars");
        showButton.addActionListener(this);
        add(showButton);

        stopButton = new JButton("Stop Animation");
        stopButton.addActionListener(this);
        add(stopButton);

        timer = new Timer(500, this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showButton) {
            showStars = true;
            timer.start();
        } else if (e.getSource() == stopButton) {
            timer.stop();
        } else if (e.getSource() == timer) {
            repaint();
        }
    }

    public void paint(Graphics g) {
        Image bufferImage = createImage(WIDTH, HEIGHT);
        Graphics bufferGraphics = bufferImage.getGraphics();

        if (showStars) {
            bufferGraphics.setColor(Color.BLACK);
            bufferGraphics.fillRect(0, 0, WIDTH, HEIGHT);

            bufferGraphics.setColor(Color.WHITE);
            int NUM_STARS = 300;
            for (int i = 0; i < NUM_STARS; i++) {
                int x = (int)(Math.random() * WIDTH);
                int y = (int)(Math.random() * HEIGHT);
                int STAR_SIZE = 1;
                bufferGraphics.fillOval(x, y, STAR_SIZE, STAR_SIZE);
            }
        }

        g.drawImage(bufferImage, 0, 0, this);
    }

    public static void main(String[] args) {
        new StarrySky();
    }
}