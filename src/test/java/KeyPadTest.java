import coins.Coin;
import coins.CoinType;
import machine.*;
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
        assertEquals(18, keypad.getNumberOfButtons());
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
        Button button = new Button(SelectionLetters.A, SelectionNumbers.FIVE);
        Position position = new Position(0.50, button);
        assertEquals("The price is 0.50", keypad.displayPrice(position));
    }

    @Test
    public void productSoldOut() {
        Button button = new Button(SelectionLetters.A, SelectionNumbers.FIVE);
        Position position = new Position(0.50, button);
        assertEquals("Position is out of stock", keypad.displayOutOfStock(position));
    }


}
