import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Daniel on 4/23/2017.
 */
public class SpecialDice{

    private static final int RANGE = 4;
    private String sideUp;
    private final String DOUBLE_LETTER = "Double Letter";
    private final String DOUBLE_POINTS = "Double Points";
    private final String BLANK_LETTER = "Blank Letter";
    private final String FORCED_HAND = "Forced Hand";


    public void SpecialDice() {

    }

    public void roll() {
        int randValue = ThreadLocalRandom.current().nextInt(1, RANGE+1);
        sideUp =
    }
}
