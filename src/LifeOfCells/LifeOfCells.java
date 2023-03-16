package LifeOfCells;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeOfCells implements ActionListener {
    JFrame frame;
    JPanel mainPanel, panel1;
    JButton bStart, bStop;

    public static void main(String[] args) {
        LifeOfCells game = new LifeOfCells();
        game.gui();
    }
    public void gui() {
        frame = new JFrame("Life of Cells");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        panel1 = new JPanel();
        bStart = new JButton("Start");
        bStart.addActionListener(this);
        bStop = new JButton("Stop");
        panel1.add(bStart);
        panel1.add(bStop);
        frame.getContentPane().add(BorderLayout.NORTH, panel1);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(1000, 600);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        frame.repaint();
    }

    public void paintComponent(Graphics g) {
        while (true) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, mainPanel.getWidth(), mainPanel.getHeight());

            int x = (int) (Math.random() * (int) (mainPanel.getWidth() / 5));
            int y = (int) (Math.random() * (int) (mainPanel.getHeight() / 5));

            g.setColor(Color.RED);
            g.fillRect(x, y, 5, 5);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //this.repaint();
        }
    }

    private int getHeight() {
        return 600;
    }

    private int getWidth() {
        return 1000;
    }
}


