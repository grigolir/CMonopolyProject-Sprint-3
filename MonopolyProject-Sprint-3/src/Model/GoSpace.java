package Model;

public class GoSpace extends Space {
    public GoSpace() {
        super("Go");
    }

    @Override
    public void landOn(Player player) {
        System.out.println(player.getName() + " landed on Go.");
    }
}
