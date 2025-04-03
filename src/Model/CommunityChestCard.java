/*
*  CommunityChestCard.java
*
* This class represents a Community Chest card in the game. It extends the Card class and provides specific implementations for various community chest cards.
*
* Created by Kristian Wright.
*/

package Model;

import java.util.Collections;
import java.util.Stack;
import java.util.function.Consumer;

public class CommunityChestCard extends Card {

    private GameBoard gameBoard;

    public CommunityChestCard(String description, Consumer<Player> effect) {
        super(description, effect);
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public static Stack<CommunityChestCard> initializeCommunityChestCards(GameBoard gameBoard) {
        Stack<CommunityChestCard> communityDeck = new Stack<>();
        communityDeck.add(new CommunityChestCard("Advance to Go (Collect $200).", player -> {player.setPosition(0); player.increaseMoney(200);}));
        communityDeck.add(new CommunityChestCard("Bank error in your favor. Collect $200.", player -> player.increaseMoney(200)));
        communityDeck.add(new CommunityChestCard("Doctor’s fee. Pay $50.", player -> player.decreaseMoney(50)));
        communityDeck.add(new CommunityChestCard("From sale of stock you get $50.", player -> player.increaseMoney(50)));
        communityDeck.add(new CommunityChestCard("Get Out of Jail Free.", Player::receiveGetOutOfJailFreeCard));
        communityDeck.add(new CommunityChestCard("Go to Jail. Go directly to jail, do not pass Go, do not collect $200.", Player::goToJail));
        communityDeck.add(new CommunityChestCard("Holiday fund matures. Receive $100.", player -> player.increaseMoney(100)));
        communityDeck.add(new CommunityChestCard("Income tax refund. Collect $20.", player -> player.increaseMoney(20)));
        communityDeck.add(new CommunityChestCard("It is your birthday. Collect $10 from every player.", _ -> {
            CommunityChestCard card = new CommunityChestCard("", null);
            card.setGameBoard(gameBoard);
            card.collectFromEachPlayer(10);
        }));
        communityDeck.add(new CommunityChestCard("Life insurance matures. Collect $100.", player -> player.increaseMoney(100)));
        communityDeck.add(new CommunityChestCard("Pay hospital fees of $100.", player -> player.decreaseMoney(100)));
        communityDeck.add(new CommunityChestCard("Pay school fees of $50.", player -> player.decreaseMoney(50)));
        communityDeck.add(new CommunityChestCard("Receive $25 consultancy fee.", player -> player.increaseMoney(25)));
        communityDeck.add(new CommunityChestCard("You are assessed for street repair. $40 per house. $115 per hotel.", _ -> {
            // Implement the assessStreetRepairs logic here
        }));
        communityDeck.add(new CommunityChestCard("You have won second prize in a beauty contest. Collect $10.", player -> player.increaseMoney(10)));
        communityDeck.add(new CommunityChestCard("You inherit $100.", player -> player.increaseMoney(100)));
        return communityDeck;
    }

    public static void shuffleCommunityChestCards(Stack<CommunityChestCard> communityDeck) {
        Collections.shuffle(communityDeck);
    }

    public void collectFromEachPlayer(int amount) {
        for (Player player : gameBoard.getPlayers()) {
            player.decreaseMoney(amount);
        }
    }
}