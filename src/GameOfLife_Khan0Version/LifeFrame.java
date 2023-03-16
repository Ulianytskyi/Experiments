package GameOfLife_Khan0Version;

import javax.swing.JFrame;
import java.awt.*;

public class LifeFrame extends JFrame {
    public LifeFrame() {
        add(new LifePanel());

        setSize(1300, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //виведення фрейма по центру екрана
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

    }

    public static void main(String[] args) {
        new LifeFrame();
    }
}
