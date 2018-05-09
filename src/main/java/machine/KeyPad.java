package machine;

import java.util.ArrayList;

public class KeyPad {
    private ArrayList<Button> buttons;

    public KeyPad() {
        this.buttons = new ArrayList<>();
        generateButtons();
    }

    private void generateButtons() {
        for (Selection selection : Selection.values()){
            Button button = new Button(selection);
            this.buttons.add(button);
        }
    }

    public int getNumberOfButtons() {
        return this.buttons.size();
    }

    public String displayCurrentBalance(CoinSlot coinSlot) {
        return String.format("%.2f", coinSlot.getCurrentBalance());
    }
}
