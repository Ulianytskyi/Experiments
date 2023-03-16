package GameOfLife_Khan0Version;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LifePanel extends JPanel implements ActionListener,
        MouseListener, MouseMotionListener, KeyListener{
    int xPanel = 1300;
    int yPanel = 700;
    int size = 10;
    int xWidth = xPanel / size;
    int yHeight = yPanel / size;
    int[][] life = new int[xWidth][yHeight];
    int[][] beforeLife = new int[xWidth][yHeight];
    boolean starts = true;
    int initial = -1;
    Timer time;
    public LifePanel() {
        setSize(xPanel, yPanel);
        setLayout(null);
        addMouseMotionListener(this);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        setBackground(Color.BLACK);

        time = new Timer(80, this);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        

        grid(g);
        display(g);
    }
    private void grid(Graphics g) {
        g.setColor(Color.DARK_GRAY);

        for (int i = 0; i < life.length; i++) {
            g.drawLine(0, i * size, xPanel, i * size); // row
            g.drawLine(i * size, 0, i * size, yPanel); // column
        }
    }
    private void spawn() {
        for (int x = 0; x < life.length; x++) {
            for (int y = 0; y < (yHeight); y++) {
                if ((int) (Math.random() * 5) == 0) {
                    beforeLife[x][y] = 1;
                }
            }
        }
    }
    private void display(Graphics g) {
        g.setColor(Color.ORANGE);

        copyArray();

        for (int x = 0; x < life.length; x++) {
            for (int y = 0; y < (yHeight); y++) {
                if (life[x][y] == 1)
                    g.fillRect(x * size, y * size, size, size);
            }
        }
    }
    private void copyArray() {
        for (int x = 0; x < life.length; x++) {
            for (int y = 0; y < (yHeight); y++) {
                life[x][y] = beforeLife[x][y];
            }
        }
    }
    private int check(int x, int y) {
        int alive = 0;

        alive += life[(x + xWidth - 1) % xWidth][(y + yHeight - 1) % yHeight];
        alive += life[(x + xWidth) % xWidth][(y + yHeight - 1) % yHeight];
        alive += life[(x + xWidth + 1) % xWidth][(y + yHeight - 1) % yHeight];
        alive += life[(x + xWidth - 1) % xWidth][(y + yHeight) % yHeight];
        alive += life[(x + xWidth + 1) % xWidth][(y + yHeight) % yHeight];
        alive += life[(x + xWidth - 1) % xWidth][(y + yHeight + 1) % yHeight];
        alive += life[(x + xWidth) % xWidth][(y + yHeight + 1) % yHeight];
        alive += life[(x + xWidth + 1) % xWidth][(y + yHeight + 1) % yHeight];

        return alive;
    }
    private void clear() {
        for (int x = 0; x < life.length; x++) {
            for (int y = 0; y < (yHeight); y++) {
                beforeLife[x][y] = 0;
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
        int alive;

        for (int x = 0; x < life.length; x++) {
            for (int y = 0; y < (yHeight); y++) {
                alive = check(x, y);

                if (alive == 3) {
                    beforeLife[x][y] = 1;
                } else if (alive == 2 && life[x][y] == 1) {
                    beforeLife[x][y] = 1;
                } else {
                    beforeLife[x][y] = 0;
                }
            }
        }
        repaint();
    }
    public void mouseDragged(MouseEvent e) {
        int x = e.getX() / size;
        int y = e.getY() / size;

        if (life[x][y] == 0 && initial == 0) {
            beforeLife[x][y] = 1;
        } else if (life[x][y] == 1 && initial == 1) {
            beforeLife[x][y] = 0;
        }
        repaint();
    }
    public void mousePressed(MouseEvent e) {

        int x = e.getX() / size;
        int y = e.getY() / size;

        if (life[x][y] == 0) {
            initial = 0;
        } else {
            initial = 1;
        }
        repaint();
    }
    public void mouseReleased(MouseEvent e) {

        initial = -1;
    }
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == e.VK_R) {
            spawn();
            time.start();
        } else if (code == e.VK_C) {
            clear();
            time.stop();
        } else if (code == e.VK_S) {
            time.start();
        }else if (code == e.VK_A) {
            time.stop();
        }
        repaint();
    }
    public void keyTyped(KeyEvent e) {

    }
    public void keyReleased(KeyEvent e) {

    }
    public void mouseMoved(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
}
