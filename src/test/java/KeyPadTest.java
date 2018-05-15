import coins.Coin;
import coins.CoinType;
import machine.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeyPadTest {
    KeyPad keypad;
    VendingMachine vendingMachine;
    CoinSlot coinSlot;

    @Before
    public void setUp() throws Exception {

        coinSlot = new CoinSlot();
        keypad = new KeyPad();
        vendingMachine = new VendingMachine(coinSlot, keypad);


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

    @Test
    public void displayCorrectChangeOnly() {
        assertEquals("Correct change only", keypad.machineNeedsCorrectChange(vendingMachine));
    }
}
