import coins.Coin;
import coins.CoinType;
import customer.Customer;
import machine.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class KeyPadTest {
    KeyPad keypad;
    VendingMachine vendingMachine;
    CoinSlot coinSlot;
    Customer customer;
    Coin onePound;
    Coin fiftyPence;

    @Before
    public void before(){
    coinSlot = new CoinSlot();
    keypad = new KeyPad();
    vendingMachine = new VendingMachine(coinSlot, keypad);
    onePound = new Coin(CoinType.ONEPOUND);
    fiftyPence = new Coin(CoinType.FIFTYPENCE);
    ArrayList<Coin> wallet = new ArrayList<>();
    wallet.add(onePound);
    wallet.add(fiftyPence);
    customer = new Customer("Paul",wallet );

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
    public void displayCorrectCanGiveChange() {
        assertEquals("Can give change", keypad.machineNeedsCorrectChange(vendingMachine));
    }

    @Test
    public void displayCorrectChangeOnly() {
        vendingMachine.emptyTill();
        assertEquals("Correct change only", keypad.machineNeedsCorrectChange(vendingMachine));
    }

    @Test
    public void countCoinsInVendingMachine() {
        assertEquals(30, vendingMachine.countNumberOfCoins());
    }
}
