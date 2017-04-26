import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by GtheP43 on 4/23/2017.
 */
public class SCTableTest {
    @Test
    public void getSc() throws Exception
    {
        SCTable table = new SCTable();
        table.refresh();
        table.reset(true);
        assertNotEquals(null, table.getSc());
    }

}
