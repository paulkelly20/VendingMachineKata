import coins.Coin;
import coins.CoinType;
import machine.CoinSlot;
import machine.KeyPad;
import machine.Position;
import machine.Selection;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeyPadTest {
    KeyPad keypad;

    @Before
    public void setUp() throws Exception {
        keypad = new KeyPad();

    }

    @Test
    public void has16Buttons() {
        assertEquals(16, keypad.getNumberOfButtons());
    }

    @Test
    public void canDisplayCurrentBalance() {
        Coin coin = new Coin(CoinType.FIFTYPENCE);
        CoinSlot coinSlot = new CoinSlot();

        coinSlot.addCoin(coin);
        assertEquals("The balance is 0.50", keypad.displayCurrentBalance(coinSlot));
    }

    @Test
    public void canDisplayPrice() {
        Position position = new Position(0.50, Selection.A1);
        assertEquals("The price is 0.50", keypad.displayPrice(position));
    }

    @Test
    public void productSoldOut() {
        Position position = new Position(0.50, Selection.A1);
        assertEquals("A1 out of stock", keypad.displayOutOfStock(position));
    }


}
