import coins.Coin;
import coins.CoinType;
import machine.*;
import org.junit.Before;
import org.junit.Test;
import products.Sweet;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    VendingMachine vendingMachine;
    CoinSlot coinSlot;
    KeyPad keyPad;
    Sweet sweet;
    Position position;
    Coin onePound;


    @Before
    public void setUp() throws Exception {
        keyPad = new KeyPad();
        coinSlot = new CoinSlot();
        onePound = new Coin(CoinType.ONEPOUND);
        vendingMachine = new VendingMachine(coinSlot, keyPad);
        sweet = new Sweet("Mars", 0.50);
        position = new Position(0.50, Selection.A1);
    }

    @Test
    public void startsWith16Positions() {
        assertEquals(16, vendingMachine.getNumberOfPositions());
    }

    @Test
    public void testNumberOfCoinsInmachine() {
        assertEquals(10, vendingMachine.countNumberOfCoins());
    }

    @Test
    public void hasFifteenQuid() {
        assertEquals(15.0, vendingMachine.getCurrentBalance(vendingMachine.getCoins()), 0.1);
    }

    @Test
    public void testEnoughMoneyInCoinSlotToBuyProduct() {
        coinSlot.addCoin(onePound);
        position.addStock(sweet);
        assertEquals(true, vendingMachine.coinslotBalanceEnoughToBuyProuct(position));
    }

    @Test
    public void testEnoughMoneyToBuyProductButProuctOutOfStock() {
        coinSlot.addCoin(onePound);
        assertEquals(false, vendingMachine.coinslotBalanceEnoughToBuyProuct(position));
    }
}
