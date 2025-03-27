package Model;

import java.util.ArrayList;

public class JailSpace extends Space {
    public JailSpace() {
        super("Jail");
    }

    @Override
    public void landOn(Player player) {
        // Logic for landing on Jail space
        System.out.println(player.getName() + " landed on Jail.");
    }

    public void rollJail(Player player) {
        ArrayList<Integer> results = player.getDice().rollDice();
        if (results.get(0) == results.get(1)){
            //player leaves jail
        }
    }
}
