/**
 * Creator: Rachele Grigoli
 *
 * This class represents the GUI of the interactive monopoly game at play
 *
 * TODO: figure out how to import Dice class from Model, and delete temporary dice buttons
 * try to resolve Model import issue 
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GUI extends JFrame {

    private JPanel gameBoardPanel;
    private JPanel gameStatePanel;


    /**
     * Initialization of GUI JPanel named gameBoardPanel
     */
    public GUI() {
        setTitle("TestMonopoly");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full-screen mode
        setLayout(new BorderLayout()); // Ensure layout is set
        gameBoardPanel = new GameBoardPanel();
        gameStatePanel = new GameStatePanel();

        add(gameBoardPanel, BorderLayout.CENTER);
        add(gameStatePanel, BorderLayout.EAST);

        setVisible(true);
    }

    private void createUIComponents() {
        gameBoardPanel = new GameBoardPanel();
        gameStatePanel = new GameStatePanel();
    }

    /**
     * Creation of GameBoard components, including:
     * - Chance and Community Chest Cards
     * - Game board spaces
     * - Buttons on board showing property details
     */
    // Custom JPanel for game board drawing
    class GameBoardPanel extends JPanel {
        private static final int SQUARE_SIZE = 82; // w and h
        private static final int BOARD_SIZE = 9;

        public GameBoardPanel() {
            setPreferredSize(new Dimension(900, 900));
            setBackground(Color.WHITE);
            setLayout(null); // This disables the layout manager, allowing you to use setBounds.

            //Initialize and add JLabel
            JLabel goSpace = new JLabel("GO");
            goSpace.setBounds(702, 722, 100, 30);
            add(goSpace);

            JLabel jailSpace = new JLabel("JAIL");
            jailSpace.setBounds(42, 722, 100, 30);
            add(jailSpace);

            JLabel parkingSpace = new JLabel("PARKING");
            parkingSpace.setBounds(30, 66, 100, 30);
            add(parkingSpace);

            JLabel goToJailSpace = new JLabel("GO TO JAIL");
            goToJailSpace.setBounds(679, 66, 100, 30);
            add(goToJailSpace);

            JButton chanceCardDeck = new JButton("<html><center>Chance<br>Card</center></html>");
            chanceCardDeck.setBounds(140, 160, 90, 120);
            chanceCardDeck.setOpaque(true);
            chanceCardDeck.setBackground(new Color(255, 165, 0));// Orange color
            chanceCardDeck.setFont(new Font("Arial", Font.BOLD, 12));
            chanceCardDeck.setMargin(new Insets(0, 0, 0, 0));
            add(chanceCardDeck);

            JButton communityChestDeck = new JButton("<html><center>Community<br>Chest</center></html>");
            communityChestDeck.setBounds(140, 300, 90, 120);
            communityChestDeck.setOpaque(true);
            communityChestDeck.setBackground(new Color(255, 215, 0));// Gold color
            communityChestDeck.setFont(new Font("Arial", Font.BOLD, 12));
            communityChestDeck.setMargin(new Insets(0, -8, 0, 0));
            add(communityChestDeck);


            // trial button for mediterranean avenue
            // button is currently on first tile
            // when pressed, property details will show
            //
            // at some point, I want to create a loop for creating all JButtons/Dialogs, linking to the
            //GameBoard.java instantiations
            JButton openMediteranneanAvenue = new JButton("<html><center>Mediterranean<br>Avenue</center></html>");
            openMediteranneanAvenue.setBounds(589, 696, 82, 82);
            openMediteranneanAvenue.setOpaque(true);
            openMediteranneanAvenue.setBackground(new Color(153, 102, 51));// Brown color
            openMediteranneanAvenue.setFont(new Font("Arial", Font.BOLD, 10));
            openMediteranneanAvenue.setMargin(new Insets(0, -14, 0, 0)); // Reduce padding
            add(openMediteranneanAvenue);

            openMediteranneanAvenue.addActionListener(e -> {
                JDialog mediterraneanAvenue = new JDialog();
                mediterraneanAvenue.setTitle("Property Info");
                mediterraneanAvenue.setSize(200, 150);
                mediterraneanAvenue.setLocationRelativeTo(null); // Center the dialog

                JLabel message = new JLabel("Hello, World!", SwingConstants.CENTER);
                mediterraneanAvenue.add(message);

                mediterraneanAvenue.setVisible(true);
            });


            revalidate();
            repaint();
        }

        // outline for gameboard tiles.
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setPaint(Color.BLACK);
            g2D.setStroke(new BasicStroke(2));

            int x = 15, y = 40;

            // Draw left column
            for (int i = 0; i < BOARD_SIZE; i++) {
                g2D.drawRect(x, y + (i * SQUARE_SIZE), SQUARE_SIZE, SQUARE_SIZE);
            }

            // Draw bottom row
            y += (BOARD_SIZE - 1) * SQUARE_SIZE;
            for (int i = 0; i < BOARD_SIZE; i++) {
                g2D.drawRect(x + (i * SQUARE_SIZE), y, SQUARE_SIZE, SQUARE_SIZE);
            }

            // Draw right column
            x += (BOARD_SIZE - 1) * SQUARE_SIZE;
            for (int i = 0; i < BOARD_SIZE; i++) {
                g2D.drawRect(x, y - (i * SQUARE_SIZE), SQUARE_SIZE, SQUARE_SIZE);
            }

            // Draw top row
            y -= (BOARD_SIZE - 1) * SQUARE_SIZE;
            for (int i = 0; i < BOARD_SIZE - 1; i++) {
                g2D.drawRect(x - (i * SQUARE_SIZE), y, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }

    /**
     * JPanel that shows gamestate, including:
     * - player state (name, buttons, etc. [anything else to add at the moment?])
     *      -> each player has their own set of buttons
     *      -> can change playerCount final int
     *      -> currently has a temporary playerName List
     */
    class GameStatePanel extends JPanel {

        final int playerCount = 4;
        List<String> playerNames = Arrays.asList("Stacy", "Alex", "Jamie", "Jordan");

        public GameStatePanel() {
            setPreferredSize(new Dimension(700, 500));
            setBackground(new Color(217, 233, 211)); // light green
            setLayout(null);

            int x = 50;
            int y = 60;
            for (int i = 0; i < playerCount; i++) {
                String[] buttonLabels = {
                        "Role Dice", "Draw Card", "Purchase Property", "Purchase House", "End Turn"
                };
                for (String label : buttonLabels) {
                    add(createButton(label, x, y));
                    x += 120; // next button's positioning
                }
                JLabel name = new JLabel(playerNames.get(i));
                name.setFont(new Font("Arial", Font.BOLD, 16));
                name.setBounds(30, y - 38, 300, 30);
                add(name);

                x = 50; // resetting x value
                y += 200; // next row of button's positioning
            }

            revalidate();
            repaint();
        }

        private JButton createButton(String text, int x, int y) {
            JButton button = new JButton(text);
            button.setBounds(x, y, 120, 20);
            button.setFont(new Font("Arial", Font.BOLD, 12));

            if (text.equals("Role Dice")) {
                button.addActionListener(e -> {
                    int roll = (int) (Math.random() * 6) + 1;
                    JOptionPane.showMessageDialog(this, "You rolled a " + roll + "!");
                });
            }

            return button;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setPaint(Color.BLACK);
            g2D.setStroke(new BasicStroke(2));

            int boxWidth = getWidth() - 60;
            int boxHeight = 150;
            int x = 30;
            int y = 50;

            for (int i = 0; i < playerCount; i++) {
                g2D.drawRect(x, y, boxWidth, boxHeight);
                g2D.drawLine(x, y + 40, boxWidth + 30, y + 40);
                y += boxHeight + 50;
            }
        }

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
