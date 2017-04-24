import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by GtheP43 on 4/23/2017.
 */
public class SpecialDiceTest {
    @Test
    public void getRange() throws Exception
    {
        SpecialDice specialDice = new SpecialDice();
        assertEquals(6,specialDice.getRange());
    }

}
