/*
 * ChanceCard.java
 *
 * This class represents a chance card in the Monopoly game.
 * It extends the Card class and provides various chance card effects.
 *
 * Created by Kristian Wright
 */

package Model;

import java.util.Collections;
import java.util.Stack;
import java.util.function.Consumer;

public class ChanceCard extends Card {

    public ChanceCard(String description, Consumer<Player> effect) {
        super(description, effect);
    }

    public static Stack<ChanceCard> initializeChanceCards() {
        Stack<ChanceCard> chanceDeck = new Stack<>();
        chanceDeck.add(new ChanceCard("Advance to Boardwalk.", player -> player.setPosition(39)));
        chanceDeck.add(new ChanceCard("Advance to Go (Collect $200).", player -> {player.setPosition(0); player.increaseMoney(200);}));
        chanceDeck.add(new ChanceCard("Advance to Illinois Avenue. If you pass Go, collect $200.", player -> {if (player.getPosition() > 24) {player.increaseMoney(200);} player.setPosition(24);}));
        chanceDeck.add(new ChanceCard("Advance to St. Charles Place. If you pass Go, collect $200.", player -> {if (player.getPosition() > 11) {player.increaseMoney(200);} player.setPosition(11);}));
        chanceDeck.add(new ChanceCard("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled.", ChanceCard::moveToNearestRailroad));
        chanceDeck.add(new ChanceCard("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown.", ChanceCard::moveToNearestUtility));
        chanceDeck.add(new ChanceCard("Bank pays you dividend of $50.", player -> player.increaseMoney(50)));
        chanceDeck.add(new ChanceCard("Get Out of Jail Free.", Player::receiveGetOutOfJailFreeCard));
        chanceDeck.add(new ChanceCard("Go Back 3 Spaces.", player -> player.move(-3)));
        chanceDeck.add(new ChanceCard("Go to Jail. Go directly to Jail, do not pass Go, do not collect $200.", Player::goToJail));
        chanceDeck.add(new ChanceCard("Make general repairs on all your property. For each house pay $25. For each hotel pay $100.", ChanceCard::makeGeneralRepairs));
        chanceDeck.add(new ChanceCard("Speeding fine $15.", player -> player.decreaseMoney(15)));
        chanceDeck.add(new ChanceCard("Take a trip to Reading Railroad. If you pass Go, collect $200.", player -> {if (player.getPosition() > 5) {player.increaseMoney(200);} player.setPosition(5);}));
        chanceDeck.add(new ChanceCard("You have been elected Chairman of the Board. Pay each player $50.", player -> ChanceCard.payEachPlayer(player, 50)));
        chanceDeck.add(new ChanceCard("Your building loan matures. Collect $150.", player -> player.increaseMoney(150)));
        return chanceDeck;
    }

    public static void shuffleChanceCards(Stack<ChanceCard> chanceDeck) {
        Collections.shuffle(chanceDeck);
    }

    // Helper methods for card actions
    public static void moveToNearestUtility(Player player) {
        int currentPosition = player.getPosition();
        int[] utilityPositions = {12, 28};
        int nearestUtility = utilityPositions[0];

        for (int pos : utilityPositions) {
            if (pos > currentPosition) {
                nearestUtility = pos;
                break;
            }
        }

        player.setPosition(nearestUtility);
        System.out.println(player.getName() + " moved to the nearest utility at position " + nearestUtility);
    }

    public static void moveToNearestRailroad(Player player) {
        GameBoard gameBoard = player.getGameBoard();
        int nearestRailroad = gameBoard.getNearestRailroad(player.getPosition());
        player.setPosition(nearestRailroad);
        System.out.println(player.getName() + " moved to the nearest railroad at position " + nearestRailroad);
    }

    public static void makeGeneralRepairs(Player player) {
        int houseRepairCost = 25;
        int hotelRepairCost = 100;
        int totalRepairCost = 0;

        for (Property property : player.getProperties()) {
            if (property.hasHotel()) {
                totalRepairCost += hotelRepairCost;
            } else {
                totalRepairCost += property.getHouseCount() * houseRepairCost;
            }
        }

        player.decreaseMoney(totalRepairCost);
        System.out.println(player.getName() + " paid $" + totalRepairCost + " for general repairs on their properties.");
    }

    public static void payEachPlayer(Player payer, int amount) {
        GameBoard gameBoard = payer.getGameBoard();
        for (Player player : gameBoard.getPlayers()) {
            if (!player.equals(payer)) {
                payer.decreaseMoney(amount);
                player.increaseMoney(amount);
                System.out.println(payer.getName() + " paid $" + amount + " to " + player.getName());
            }
        }
    }
}