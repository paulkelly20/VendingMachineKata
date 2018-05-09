import machine.Position;
import machine.Selection;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {
    Position position;

    @Before
    public void setUp() throws Exception {
        position = new Position(0.50, Selection.A1);
    }

    @Test
    public void stockLevelStartsAt0() {
        assertEquals(0, position.getStockLevel());
    }

    
}

