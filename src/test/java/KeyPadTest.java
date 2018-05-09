import machine.KeyPad;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeyPadTest {
    KeyPad keypad;

    @Before
    public void setUp() throws Exception {
        keypad = new KeyPad();
    }

    @Test
    public void has16Buttons() {
        assertEquals(16, keypad.getNumberOfButtons());
    }
}
