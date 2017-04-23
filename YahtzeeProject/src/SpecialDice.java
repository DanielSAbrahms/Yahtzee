import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Daniel on 4/23/2017.
 */
public class SpecialDice{

    private static final int RANGE = 4;
    private String sideUp;
    private int rollsLeft;
    private final String DOUBLE_LETTER = "Double Letter";
    private final String DOUBLE_POINTS = "Double Points";
    private final String BLANK_LETTER = "Blank Letter";
    private final String FORCED_HAND = "Forced Hand";
    private final String[] sideArray = {DOUBLE_LETTER, DOUBLE_POINTS, BLANK_LETTER, FORCED_HAND};


    public SpecialDice() {
        rollsLeft = 3;
        roll();
    }

    public void roll() {
        rollsLeft--;
        int randValue = ThreadLocalRandom.current().nextInt(0, RANGE);
        sideUp = sideArray[randValue];
    }

    public String getSideUp() {
        return sideUp;
    }

    public void setSideUp(String sideUp) {
        this.sideUp = sideUp;
    }

    public int getRollsLeft() {
        return rollsLeft;
    }

    public void setRollsLeft(int rollsLeft) {
        this.rollsLeft = rollsLeft;
    }

    public static int getRANGE() {
        return RANGE;
    }
}
