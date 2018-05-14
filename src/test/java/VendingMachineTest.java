import coins.Coin;
import coins.CoinType;
import customer.Customer;
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
    Coin fiftyPence;
    Customer customer;


    @Before
    public void setUp() throws Exception {
        keyPad = new KeyPad();
        coinSlot = new CoinSlot();
        onePound = new Coin(CoinType.ONEPOUND);
        vendingMachine = new VendingMachine(coinSlot, keyPad);
        sweet = new Sweet("Mars", 0.50);
        position = new Position(0.50, Selection.A1);
        onePound = new Coin(CoinType.ONEPOUND);
        fiftyPence = new Coin(CoinType.FIFTYPENCE);
        ArrayList<Coin> wallet = new ArrayList<>();
        wallet.add(onePound);
        wallet.add(fiftyPence);
        customer = new Customer("Paul", wallet);
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
        assertEquals(15.0, vendingMachine.getCurrentBalance(vendingMachine.getTill()), 0.1);
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

    @Test
    public void coinsFromCoinSlotGoToTill() {
        coinSlot.addCoin(onePound);
        vendingMachine.addMulitpleCoinsToTill(coinSlot.coinSlotReleasesAllCoins());
        assertEquals(11,vendingMachine.countNumberOfCoins());
    }

    @Test
    public void tillGivesChange(){
        vendingMachine.giveChange(3.00, customer);
        assertEquals(9, vendingMachine.countNumberOfCoins());
    }
}
