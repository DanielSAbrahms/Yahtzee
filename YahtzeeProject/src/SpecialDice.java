import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Daniel Abrahms
 * @version 1.1
 */
public class SpecialDice{

    private static final int RANGE = 6;
    private final String DOUBLE_LETTER = "Double Letter";
    private final String DOUBLE_POINTS = "Double Points";
    private final String BLANK_LETTER = "Blank Letter";
    private final String FORCED_HAND = "Forced Hand";
    private final String[] sideArray = {DOUBLE_LETTER, DOUBLE_LETTER, DOUBLE_POINTS, DOUBLE_POINTS, BLANK_LETTER, FORCED_HAND};
    private String value;

    /**
     * Creates the Special Dice Object, and rolls automatically
     */
    public SpecialDice() {
        roll();
    }

    /**
     * @return returns the range of the special dice
     */
    public static int getRange() {
        return RANGE;
    }

    /**
     * Generates a random value
     */
    public void roll() {
        int randValue = ThreadLocalRandom.current().nextInt(0, RANGE);
        value = sideArray[randValue];
    }

    /**
     * @return The value of the Die
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the String value for the value member to be set to
     */
    public void setValue(String value) {
        this.value = value;
    }
}
