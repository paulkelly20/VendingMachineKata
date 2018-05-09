import org.junit.Before;
import org.junit.Test;
import products.Sweet;

import static org.junit.Assert.assertEquals;

public class SweetTest {
    Sweet sweet;

    @Before
    public void before() throws Exception {
        sweet = new Sweet("Percy Pigs", 1.60);
    }

    @Test
    public void hasName() {
        assertEquals("Percy Pigs", sweet.getName());
    }

    @Test
    public void canSetPrice() {
        sweet.setPrice(2.00);
        assertEquals(2.00, sweet.getPrice(), 0.1);
    }


}
