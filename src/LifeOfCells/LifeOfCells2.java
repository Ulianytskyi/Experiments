package LifeOfCells;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LifeOfCells2 implements ActionListener {
    JFrame frame;

    int nudResolution = 3;
    int nudDensity = 2;

    private int resolution;
    private boolean[][] field;
    private int rows;
    private int cols;

    public static void main(String[] args) {
        LifeOfCells2 gui = new LifeOfCells2();
        gui.go();
    }
    public void go() {
        frame = new JFrame("Life of Cells, version 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Start");
        button.addActionListener(this);

        resolution = nudResolution;
        rows = frame.getHeight() / resolution;
        cols = frame.getWidth() / resolution;
        field = new boolean[cols][rows];

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                if ((int) (Math.random() * nudDensity) == 0) {
                    field[x][y] = true;
                    System.out.print("0 ");
                }
            }
        }

        JPanel fieldGen = new JPanel();

        frame.getContentPane().add(BorderLayout.NORTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, fieldGen);
        frame.setSize(1000, 600);
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent event) {
        frame.repaint();

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());

        boolean[][] newField = new boolean[cols][rows];

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
                    g.fillRect(x, y, 5, 5);
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

                boolean isSelfChecking = false;
                if (col == x && row == y) {
                    isSelfChecking = true;
                }
                boolean hasLife = field[col][row];

                if (hasLife && !isSelfChecking) {
                    count++;
                }
            }
        }

        return count;
    }
}

//class FieldGeneration extends JPanel {
//    public void paintComponent(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g.setColor(Color.BLACK);
//        g.fillRect(0, 0, getWidth(), getHeight());
//
//        int x = (int) (Math.random() * getWidth());
//        int y = (int) (Math.random() * getHeight());
//
//        g.setColor(Color.RED);
//        g.fillRect(x, y, 5, 5);
//    }
//}
