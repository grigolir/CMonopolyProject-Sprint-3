package View;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private JPanel panelMain;

    /**
     * initialization of GUI JPanel
     */
    public GUI() {
        panelMain = new JPanel();
        add(panelMain);
        setTitle("TestMonopoly");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth, screenHeight);
        setLocation(0, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * creating squares for GUI JPanel
     * @param g the specified Graphics window
     * square: 80 x 80 pixels
     * space on right of game board can show all player stats
     */
    public void paint(Graphics g) {
        Graphics2D g2D1 = (Graphics2D) g;
        g2D1.setPaint(Color.BLACK);
        g2D1.setStroke(new BasicStroke(2));
        //top row
        int y1 = 40;
        int x1 = 0;

        g2D1.drawRect(0, y1, 80, 80);
        for (int i = 0; i < 9; i++) { // left column
            y1 += 80;
            g2D1.drawRect(0, y1, 80, 80);
        }
        for (int i = 0; i < 9; i++) { // bottom row
            x1 += 80;
            g2D1.drawRect(x1, y1, 80, 80);

        }
        for (int i = 0; i < 9; i++) { // right column
            y1 -= 80;
            g2D1.drawRect(x1, y1, 80, 80);
        }
        for (int i = 0; i < 8; i++) { // top row
            x1 -= 80;
            g2D1.drawRect(x1, y1, 80, 80);
        }

    }


    public static void main(String[] args) {
        new GUI();
    }
}
