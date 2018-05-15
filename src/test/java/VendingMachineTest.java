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
    Button button;


    @Before
    public void setUp() throws Exception {
        keyPad = new KeyPad();
        coinSlot = new CoinSlot();
        onePound = new Coin(CoinType.ONEPOUND);
        vendingMachine = new VendingMachine(coinSlot, keyPad);
        sweet = new Sweet("Mars", 0.50);
        button = new Button(SelectionLetters.A, SelectionNumbers.FIVE);
        position = new Position(0.50, button);
        onePound = new Coin(CoinType.ONEPOUND);
        fiftyPence = new Coin(CoinType.FIFTYPENCE);
        ArrayList<Coin> wallet = new ArrayList<>();
        wallet.add(onePound);
        wallet.add(fiftyPence);
        wallet.add(fiftyPence);
        wallet.add(fiftyPence);
        wallet.add(fiftyPence);
        customer = new Customer("Paul", wallet);
    }

    @Test
    public void startsWith18Positions() {
        assertEquals(18, vendingMachine.getNumberOfPositions());
    }

    @Test
    public void testNumberOfCoinsInmachine() {
        assertEquals(30, vendingMachine.countNumberOfCoins());
    }

    @Test
    public void hasFifteenQuid() {
        assertEquals(19.25, vendingMachine.getCurrentBalance(vendingMachine.getTill()), 0.1);
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
        assertEquals(31,vendingMachine.countNumberOfCoins());
    }

    @Test
    public void tillGivesChange(){
        vendingMachine.giveChange(2.00, customer);
        assertEquals(29, vendingMachine.countNumberOfCoins());
    }

    @Test
    public void tillGivesThreePoundChange(){
        vendingMachine.giveChange(3.00, customer);
        assertEquals(28, vendingMachine.countNumberOfCoins());
        assertEquals(7, customer.countCoinsInWallet());
    }

    @Test
    public void customerBuysProduct() {
        position.addStock(sweet);
        coinSlot.addCoin(customer.giveCoin(onePound));
        vendingMachine.sellProduct(position, customer);
        assertEquals(0, position.getStockLevel());
    }

    @Test
    public void customerBuysProductCheckChange() {
        position.addStock(sweet);
        coinSlot.addCoin(customer.giveCoin(onePound));
        coinSlot.addCoin(customer.giveCoin(fiftyPence));
        coinSlot.addCoin(customer.giveCoin(fiftyPence));
        coinSlot.addCoin(customer.giveCoin(fiftyPence));
        vendingMachine.sellProduct(position, customer);
        assertEquals(2.50, customer.walletTotal(), 0.01);
    }
}
