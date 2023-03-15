package LifeOfCells;

import java.awt.*;
import javax.swing.*;

public class DrawSquare extends JFrame {
    public DrawSquare() {

        this.setSize(500, 500);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        while (true) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            int x = (int) (Math.random() * 500);
            int y = (int) (Math.random() * 500);

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

    public static void main(String[] args) {
        DrawSquare ds = new DrawSquare();
    }
}