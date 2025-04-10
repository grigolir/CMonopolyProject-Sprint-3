package ViewTests;

import Model.Dice;
import View.DiceView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiceViewTest {
    private Dice dice;
    private DiceView diceView;

    @BeforeEach
    public void setUp() {
        dice = Dice.getInstance();
        diceView = new DiceView(dice);
    }

    @Test
    public void testDisplayRollResults() {
        String result = diceView.displayRollResults();
        assertNotNull(result, "Roll results should not be null.");
        assertTrue(result.contains("Rolled:"), "Roll results should contain 'Rolled:' text.");
    }

    @Test
    public void testDisplayDoublesRolled() {
        dice.rollDice(); // Roll the dice to potentially get doubles
        String result = diceView.displayDoublesRolled();
        assertNotNull(result, "Doubles rolled display should not be null.");
        assertTrue(result.contains("Current doubles rolled:"), "Doubles rolled display should contain 'Current doubles rolled:' text.");
    }

    @Test
    public void testResetDoublesRolled() {
        dice.rollDice(); // Roll the dice to potentially get doubles
        diceView.resetDoublesRolled();
        assertEquals(0, dice.getDoublesRolled(), "Doubles rolled count should be reset to 0.");
    }
}