package ViewTests;

import Model.Bank;
import Model.GameBoard;
import Model.Player;
import Model.Property;
import View.GameBoardView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameBoardViewAndMainTest {
    private GameBoardView gameBoardView;
    private Bank bank;

    @BeforeEach
    public void setUp() {
        System.out.println("Setting up the test environment...");

        // Create a list of properties
        List<Property> properties = new ArrayList<>();
        this.bank = new Bank(properties); // Initialize the bank first

        // Add properties to the list with all required arguments
        properties.add(new Property("Park Place", 350, "Blue", bank));
        properties.add(new Property("Boardwalk", 400, "Blue", bank));

        String player1Token = "Top Hat";
        String player2Token = "Battleship";

        Player player1 = new Player("Player 1", player1Token, null);
        Player player2 = new Player("Player 2", player2Token, null);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        GameBoard gameBoard = new GameBoard(players, true, bank); // Test mode enabled

        player1.setGameBoard(gameBoard);
        player2.setGameBoard(gameBoard);

        gameBoardView = new GameBoardView(gameBoard);

        System.out.println("Test environment setup complete.");
    }

    @Test
    public void testDisplayBoard() {
        System.out.println("Starting testDisplayBoard...");
        gameBoardView.displayBoard();
        System.out.println("Finished testDisplayBoard.");
    }

    @Test
    public void testDisplayPlayerStatus() {
        System.out.println("Starting testDisplayPlayerStatus...");
        gameBoardView.displayPlayerStatus();
        System.out.println("Finished testDisplayPlayerStatus.");
    }
}