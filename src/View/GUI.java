package View;

import javax.swing.*;

public class GUI extends JFrame {
    private JPanel panelMain;
    public GUI() {
        panelMain = new JPanel();
        add(panelMain);
        setTitle("TestMonopoly");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocation(500, 200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
    }
}
