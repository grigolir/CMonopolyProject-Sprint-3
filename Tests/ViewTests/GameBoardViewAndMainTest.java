/**
 * GameBoardViewAndMainTest.java

 * This file contains unit tests for the GameBoardView class in the Monopoly game view.

 * Created by Kristian Wright
 */

package ViewTests;

import Model.Bank;
import Model.GameBoard;
import Model.Player;
import View.GameBoardView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for the GameBoardView class.
 */
public class GameBoardViewAndMainTest {
    private GameBoardView gameBoardView;
    private final Bank bank;

    public GameBoardViewAndMainTest(Bank bank) {
        this.bank = bank;
    }

    /**
     * Sets up the test environment before each test.
     * Initializes a new GameBoard object and a GameBoardView object.
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Setting up the test environment...");

        // Directly assign tokens to players
        String player1Token = "Top Hat";
        String player2Token = "Battleship";

        // Create players
        Player player1 = new Player("Player 1", player1Token, null);
        Player player2 = new Player("Player 2", player2Token, null);

        // Create a list of players
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        // Create a game board with the list of players
        GameBoard gameBoard = new GameBoard(players, true, bank);  // Test mode enabled

        // Set the game board for each player
        player1.setGameBoard(gameBoard);
        player2.setGameBoard(gameBoard);

        // Create a GameBoardView instance
        gameBoardView = new GameBoardView(gameBoard);

        System.out.println("Test environment setup complete.");
    }

    /**
     * Tests the display of the game board.
     * Verifies that the game board is displayed correctly.
     */
    @Test
    public void testDisplayBoard() {
        System.out.println("Starting testDisplayBoard...");
        gameBoardView.displayBoard();
        System.out.println("Finished testDisplayBoard.");
    }

    /**
     * Tests the display of player status.
     * Verifies that the player status is displayed correctly.
     */
    @Test
    public void testDisplayPlayerStatus() {
        System.out.println("Starting testDisplayPlayerStatus...");
        gameBoardView.displayPlayerStatus();
        System.out.println("Finished testDisplayPlayerStatus.");
    }
}