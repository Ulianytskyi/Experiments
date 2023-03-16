package LifeOfCells;

import javax.swing.*;
import java.awt.*;

public class LifeOfCells3 extends JFrame {
    static int nudResolution = 3;
    static int nudDensity = 2;
    static int width = 1000;
    static int height = 600;
    static int resolution;
    private static boolean[][] field;
    private static int rows;
    private static int cols;

    public LifeOfCells3() {
        //Timer timer = new Timer(500, arg0 -> LifeOfCells3.this.repaint());
        //timer.start();

        LifeOfCells3.this.repaint();
    }
    public static void main(String[] args) {
        resolution = nudResolution;
        rows = width / resolution;
        cols = height / resolution;
        field = new boolean[cols][rows];

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                field[x][y] = (int) (Math.random() * nudDensity) == 0;
            }
        }

        LifeOfCells3 frame = new LifeOfCells3();
        frame.setSize(1000, 600);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        var newField = new boolean[cols][rows];

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                int neighboursCount = CountNeighbours(x, y);
                boolean hasLife = field[x][y];

                if(!hasLife && neighboursCount == 3) {
                    newField[x][y] = true;
                } else if (hasLife && neighboursCount <2 || neighboursCount >3) {
                    newField[x][y] = false;
                } else {
                    newField[x][y] = field[x][y];
                }

                if(hasLife) {
                    g.setColor(Color.RED);
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
    }

    private int CountNeighbours(int x, int y) {
        int count = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int col = (x + i + cols) % cols;
                int row = (y + j + rows) % rows;

                boolean isSelfChecking = col == x && row == y;
                boolean hasLife = field[col][row];

                if (hasLife && !isSelfChecking) {
                    count++;
                }
            }
        }

        return count;
    }
}
