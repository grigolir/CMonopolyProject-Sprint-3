/*
 * TaxSpace.java
 *
 * This class represents a tax space on the board in a Monopoly-like game.
 * When a player lands on this space, they will pay a specified tax amount.
 *
 * Remodeled by Finn Dempsey
 */
package Model;

public class TaxSpace extends Space {
    private final int taxAmount;

    public TaxSpace(String name, int location, int taxAmount) {
        super(name);
        this.taxAmount = taxAmount;
    }

    @Override
    public void landOn(Player player) {
        player.decreaseMoney(taxAmount);
        System.out.println(player.getName() + " landed on " + name + " and paid $" + taxAmount + ".");
    }

    public int getTaxAmount() {
        return taxAmount;
    }
}
