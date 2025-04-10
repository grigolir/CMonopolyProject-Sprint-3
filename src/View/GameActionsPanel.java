package View;

import javax.swing.*;

public class GameActionsPanel extends JPanel {
    public GameActionsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JButton("Roll Dice"));
        add(new JButton("Start Trade"));
        add(new JButton("Mortgage Property"));
        add(new JButton("Buy House/Hotel"));
        add(new JButton("End Turn"));
    }
}
