package GameOfLife_Khan0Version;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.util.Random;

public class LifePanel extends JPanel{
    int xPanel = 1300;
    int yPanel = 700;
    int size = 10;
    boolean[][] life = new boolean[xPanel / size][yPanel / size];
    boolean starts = true;
    public LifePanel() {
        setSize(xPanel, yPanel);
        setLayout(null);
        setBackground(Color.BLACK);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        grid(g);

        spawn(g);
        display(g);
    }
    private void grid(Graphics g) {
        g.setColor(Color.DARK_GRAY);

        for (int i = 0; i < life.length; i++) {
            g.drawLine(0, i * size, xPanel, i * size); // row
            g.drawLine(i * size, 0, i * size, yPanel); // column
        }
    }
    private void spawn(Graphics g) {
        if (starts) {
            for (int x = 0; x < life.length; x++) {
                for (int y = 0; y < (yPanel / size); y++) {
                    if ((int) (Math.random() * 5) == 0) {
                        life[x][y] = true;
                    }
                }
            }
            starts = false;
        }
    }
    private void display(Graphics g) {
        g.setColor(Color.ORANGE);
        for (int x = 0; x < life.length; x++) {
            for (int y = 0; y < (yPanel / size); y++) {
                if (life[x][y])
                    g.fillRect(x * size, y * size, size, size);
            }
        }
    }
}
