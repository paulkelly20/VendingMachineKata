import coins.Coin;
import coins.CoinType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {
    Coin coin;

    @Before
    public void setUp() throws Exception {
        coin = new Coin(CoinType.ONEPOUND);
    }

    @Test
    public void canGetWeightFromEnum() {
        assertEquals(9.5, coin.getWeightFromEnum(), 0.1);
    }



}
