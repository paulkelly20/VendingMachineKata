import machine.Button;
import machine.Position;
import machine.SelectionLetters;
import machine.SelectionNumbers;
import org.junit.Before;
import org.junit.Test;
import products.Product;
import products.Sweet;

import static org.junit.Assert.assertEquals;

public class PositionTest {
    Position position;
    Button button;

    @Before
    public void setUp() throws Exception {
        button = new Button(SelectionLetters.A, SelectionNumbers.FIVE);
        position = new Position(0.50, button);
    }

    @Test
    public void stockLevelStartsAt0() {
        assertEquals(0, position.getStockLevel());
    }

    @Test
    public void canAddProduct() {
        Sweet sweet = new Sweet("Mars Bar", 0.50);
        position.addStock(sweet);
        assertEquals(1, position.getStockLevel());
    }

    @Test
    public void canDispenseProduct() {
        Sweet sweet = new Sweet("Mars Bar", 0.50);
        position.addStock(sweet);
        position.addStock(sweet);
        position.addStock(sweet);
        position.dispenseProduct();
        assertEquals(2, position.getStockLevel());
    }

    @Test
    public void checkIfProductIsInStock() {
        Sweet sweet = new Sweet("Mars Bar", 0.50);
        position.addStock(sweet);
        assertEquals(true, position.checkStock(sweet));
    }

    @Test
    public void checkIfProductIsInStockReturnsFalse() {
        Product sweet = new Sweet("Mars Bar", 0.50);
        position.addStock(sweet);
        position.dispenseProduct();
        assertEquals(false, position.checkStock(sweet));
    }
}

