import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by GtheP43 on 4/23/2017.
 */
public class DiceTest {
    @Test
    public void getPoints() throws Exception
    {
        Dice die = new Dice(false);
        assertEquals(false,die.getIsVowel());
    }

}
