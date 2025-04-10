package View;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {
    public PlayerPanel(String playerName) {
        setLayout(new BorderLayout());
        JLabel moneyLabel = new JLabel("Money: $1500");
        JPanel props = new JPanel();
        props.setLayout(new BoxLayout(props, BoxLayout.Y_AXIS));
        props.add(new JLabel("Mediterranean Avenue (Mortgaged)"));
        props.add(new JLabel("Baltic Avenue"));

        add(moneyLabel, BorderLayout.NORTH);
        add(new JScrollPane(props), BorderLayout.CENTER);
    }
}
