import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by GtheP43 on 4/23/2017.
 */
public class ScoreCardTest {
    @Test
    public void getTotalScore() throws Exception {
        ScoreCard card = new ScoreCard();
        assertEquals(false,card.bonusUsed);
    }



}
