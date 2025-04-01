package ModelTests;

import Model.ChanceCard;
import Model.GameBoard;
import Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChanceCardTest {
    private GameBoard gameBoard;
    private Player player1;

    @BeforeEach
    public void setUp() {
        List<Player> players = new ArrayList<>();
        gameBoard = new GameBoard(players);
        player1 = new Player("Player 1", "Token1", gameBoard);
        Player player2 = new Player("Player 2", "Token2", gameBoard);
        players.add(player1);
        players.add(player2);
    }

    @Test
    public void testShuffleChanceCards() {
        List<String> originalOrder = new ArrayList<>();
        gameBoard.getChanceDeck().forEach(card -> originalOrder.add(card.getDescription()));

        ChanceCard.shuffleChanceCards(gameBoard.getChanceDeck());

        List<String> shuffledOrder = new ArrayList<>();
        gameBoard.getChanceDeck().forEach(card -> shuffledOrder.add(card.getDescription()));

        assertNotEquals(originalOrder, shuffledOrder, "Chance cards should be shuffled.");
    }

    @Test
    public void testDrawGoToJailCard() {
        ChanceCard goToJailCard = new ChanceCard("Go to Jail", Player::goToJail);

        player1.setPosition(7); // Assume player is on Chance space
        goToJailCard.apply(player1);

        assertEquals(10, player1.getPosition(), "Player 1 should be in Jail.");
        assertTrue(player1.isInJail(), "Player 1 should be in jail.");
    }

    @Test
    public void testDrawAdvanceToRailroadCard() {
        ChanceCard advanceToRailroadCard = new ChanceCard("Advance to Nearest Railroad", (player) -> {
            int newPosition = gameBoard.getNearestRailroad(player.getPosition());
            player.setPosition(newPosition);
        });

        player1.setPosition(7); // Assume player is on Chance space
        advanceToRailroadCard.apply(player1);

        int expectedRailroadPosition = gameBoard.getNearestRailroad(7);
        assertEquals(expectedRailroadPosition, player1.getPosition(), "Player 1 should be on the nearest Railroad.");
        assertTrue(gameBoard.getSpace(player1.getPosition()).getName().contains("Railroad"), "Player 1 should be on a Railroad space.");
    }
}