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
        return String.format("The balance is %.2f", coinSlot.getCurrentBalance());
    }

    public String displayPrice(Position position) {
        return String.format("The price is %.2f", position.getPrice());
    }

    public String thankYou(){
        return "Thank You!";
    }

}
