import coins.Coin;
import coins.CoinType;
import machine.CoinSlot;
import machine.KeyPad;
import machine.VendingMachine;
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
    ArrayList<Coin> coins;

    @Before
    public void setUp() throws Exception {
        keyPad = new KeyPad();
        coinSlot = new CoinSlot();
        coins = new ArrayList<>();
        for (int i = 0; i < 5; i++){
           coins.add(new Coin(CoinType.ONEPOUND));
           coins.add(new Coin(CoinType.TWOPOUND));
        }

        vendingMachine = new VendingMachine(coinSlot, keyPad, coins);
    }

    @Test
    public void startsWith16Positions() {
        assertEquals(16, vendingMachine.getNumberOfPositions());
    }

//    @Test
//    public void hasFifteenQuid() {
//        assertEquals(15.0, vendingMachine.getFloat(), 0.1);
//    }
}
