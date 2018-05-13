import coins.Coin;
import coins.CoinType;
import customer.Customer;
import machine.CoinSlot;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CoinSlotTest {
    CoinSlot coinslot;
    Coin onePound;
    Coin fiftyPence;
    Customer customer;

    @Before
    public void setUp() throws Exception {
        coinslot = new CoinSlot();
        onePound = new Coin(CoinType.ONEPOUND);
        fiftyPence = new Coin(CoinType.FIFTYPENCE);
        ArrayList<Coin> wallet = new ArrayList<>();
        wallet.add(onePound);
        wallet.add(fiftyPence);
        customer = new Customer("Paul", wallet);

    }

    @Test
    public void hasEmptyArray() {
        assertEquals(0, coinslot.countNumberOfCoins());
    }

    @Test
    public void canAddValidCoin() {
        coinslot.addCoin(onePound);
        assertEquals(1, coinslot.countNumberOfCoins());
    }

    @Test
    public void cannotAcceptInvalidCoin() {
        Coin invalidCoin = new Coin(CoinType.ONEPENCE);
        coinslot.addCoin(invalidCoin);
        assertEquals(0, coinslot.countNumberOfCoins());
    }

    @Test
    public void canCalculateSingleCoinValue() {
        assertEquals(1.00, onePound.getCoinValue(), 0.1);
        assertEquals(0.50, fiftyPence.getCoinValue(), 0.1);
    }

    @Test
    public void coinSlotCanCalculateMultipleCoinsValue() {
        coinslot.addCoin(onePound);
        coinslot.addCoin(fiftyPence);
        assertEquals(1.50, coinslot.getCurrentBalance(), 0.1);
    }

    @Test
    public void coinSlotReturnsAllCoins() {
        coinslot.addCoin(onePound);
        coinslot.addCoin(fiftyPence);
        coinslot.returnAllCoins();
        assertEquals(0, coinslot.countNumberOfCoins());
    }
}
