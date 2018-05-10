import coins.Coin;
import coins.CoinType;
import customer.Customer;
import machine.CoinSlot;
import org.junit.Before;
import org.junit.Test;
import products.Product;
import products.Sweet;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer customer;
    CoinSlot coinslot;
    Coin onePound;
    Coin fiftyPence;
    Product product;

    @Before
    public void before(){
        coinslot = new CoinSlot();
        onePound = new Coin(CoinType.ONEPOUND);
        fiftyPence = new Coin(CoinType.FIFTYPENCE);
        ArrayList<Coin> wallet = new ArrayList<>();
        wallet.add(onePound);
        wallet.add(fiftyPence);
        customer = new Customer("Paul",wallet );
        product = new Sweet("Mars", 0.50);

    }

    @Test
    public void testCoinsInWallet() {
        assertEquals(2, customer.countCoinsInWallet());
    }

    @Test
    public void customerHasEmptyPocket() {
            assertEquals(0, customer.getProductCount());
    }

    @Test
    public void addProductToPocketCustomerHasOneItemInPocket() {
        customer.addProductToPocket(product);
        assertEquals(1, customer.getProductCount());
    }

    @Test
    public void addCoinToCoinSlotCheckWalletAmountAfter() {
        customer.insertCoin(onePound);
        assertEquals(1, customer.countCoinsInWallet());
    }
}
