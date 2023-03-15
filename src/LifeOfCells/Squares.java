package LifeOfCells;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Squares extends JFrame {

    int x = -1;
    int inc;

    public Squares() {
        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Squares.this.repaint();
            }
        });
        timer.start();
    }

    public void paint(Graphics g) {
        // don't call super.paint(g), we do all the painting

        if(x > getWidth()) inc = -5;
        if(x < 0) inc = 5;

        x += inc;

        // here we clear everything
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLUE);
        g.drawLine(x, 0, getWidth()-x, getHeight());
    }

    public static void main(String[] args) {
        Squares mainFrame = new Squares();
        mainFrame.setSize(800, 600);
        mainFrame.setVisible(true);
    }
}
