import machine.SelectionLetters;
import machine.Button;
import machine.SelectionNumbers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ButtonTest {
    Button button;

    @Before
    public void setUp() {
        button = new Button(SelectionLetters.A, SelectionNumbers.FIVE);
    }

    @Test
    public void hasASelectionEnum() {
        assertEquals(SelectionLetters.A,  button.getSelectionletter());
    }



}
