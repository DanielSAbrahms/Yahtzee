import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Daniel on 4/23/2017.
 */
public class SpecialDice{

    private static final int RANGE = 6;
    private final String DOUBLE_LETTER = "Double Letter";
    private final String DOUBLE_POINTS = "Double Points";
    private final String BLANK_LETTER = "Blank Letter";
    private final String FORCED_HAND = "Forced Hand";
    private final String[] sideArray = {DOUBLE_LETTER, DOUBLE_LETTER, DOUBLE_POINTS, DOUBLE_POINTS, BLANK_LETTER, FORCED_HAND};
    private String value;
    private int usesLeft;


    public SpecialDice() {
        usesLeft = 3;
        roll();
    }

    public static int getRange() {
        return RANGE;
    }

    public void roll() {
        usesLeft--;
        int randValue = ThreadLocalRandom.current().nextInt(0, RANGE);
        value = sideArray[randValue];
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getUsesLeft() {
        return usesLeft;
    }

    public void setUsesLeft(int usesLeft) {
        this.usesLeft = usesLeft;
    }
}
