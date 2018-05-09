import coins.Coin;
import coins.CoinType;
import machine.CoinSlot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinSlotTest {
    CoinSlot coinSlot;
    Coin onePound;
    Coin fiftyPence;

    @Before
    public void setUp() throws Exception {
        coinSlot = new CoinSlot();
        onePound = new Coin(CoinType.ONEPOUND);
        fiftyPence = new Coin(CoinType.FIFTYPENCE);
    }

    @Test
    public void hasEmptyArray() {
        assertEquals(0, coinSlot.countNumberOfCoins());
    }

    @Test
    public void canAddCoin() {
        coinSlot.addCoin(onePound);
        assertEquals(1, coinSlot.countNumberOfCoins());
    }
}
