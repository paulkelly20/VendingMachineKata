import machine.Selection;
import machine.Button;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ButtonTest {
    Button button;

    @Before
    public void setUp() throws Exception {
        button = new Button(Selection.A1);
    }

    @Test
    public void hasASelectionEnum() {
        assertEquals(Selection.A1, button.getSelection());
    }
}
