import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by GtheP43 on 4/23/2017.
 */
public class ScoreCardLineTest {


    @Test
    public void getPotentialPoints() throws Exception
    {
        ScoreCardLine word = new ScoreCardLine(String.valueOf(1), 1, false);
        word.setPointsEarned(8);
        assertEquals(8,word.getPointsEarned());
    }

    @Test
    public void getWordScored() throws Exception
    {
        ScoreCardLine word = new ScoreCardLine(String.valueOf(1), 1, false);
        word.setName("cows");
        assertEquals("cows",word.getName());
    }

}
