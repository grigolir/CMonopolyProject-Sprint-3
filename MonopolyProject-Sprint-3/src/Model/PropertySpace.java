package Model;

public class PropertySpace extends Space {
    private final int price;
    private final int propertySite;
    private final int propertySiteWithColorSet;
    private final int costWithOneHouse;
    private final int costWithTwoHouses;
    private final int costWithThreeHouses;
    private final int costWithFourHouses;
    private final int costWithHotel;
    private final int mortgageValue;
    private final int costOfHouseHotel;
    private Player owner;

    public PropertySpace(String name, int location, String color, int price, int propertySite, int propertySiteWithColorSet,
                         int costWithOneHouse, int costWithTwoHouses, int costWithThreeHouses, int costWithFourHouses,
                         int costWithHotel, int mortgageValue, int costOfHouseHotel) {
        super(name);
        this.price = price;
        this.propertySite = propertySite;
        this.propertySiteWithColorSet = propertySiteWithColorSet;
        this.costWithOneHouse = costWithOneHouse;
        this.costWithTwoHouses = costWithTwoHouses;
        this.costWithThreeHouses = costWithThreeHouses;
        this.costWithFourHouses = costWithFourHouses;
        this.costWithHotel = costWithHotel;
        this.mortgageValue = mortgageValue;
        this.costOfHouseHotel = costOfHouseHotel;
        this.owner = null; // Initially unowned
    }

    @Override
    public void landOn(Player player) {
        if (owner == null) {
            System.out.println(player.getName() + " landed on " + name + " which is unowned.");
        } else if (owner != player) {
            int rent = calculateRent();
            player.decreaseMoney(rent);
            owner.increaseMoney(rent);
            System.out.println(player.getName() + " landed on " + name + " and paid $" + rent + " rent to " + owner.getName());
        } else {
            System.out.println(player.getName() + " landed on their own property " + name + ".");
        }
    }

    public int calculateRent() {
        // Example rent calculation logic
        return price / 10;
    }

    public void buy(Player player) {
        if (owner == null) {
            owner = player;
            player.decreaseMoney(price);
            System.out.println(player.getName() + " bought " + name + " for $" + price);
        }
    }

    public boolean isOwned() {
        return owner != null;
    }

    public Player getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }
}
