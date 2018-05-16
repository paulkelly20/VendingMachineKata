package machine;

import java.util.ArrayList;

public class KeyPad {
    private ArrayList<Button> buttons;

    public KeyPad() {
        this.buttons = new ArrayList<>();
        generateButtons(3);
    }

    private void generateButtons(int numberOfRows) {
        for (int i = 0; i < numberOfRows; i++) {
            for (int y = 0; y < 9; y++) {
                Button button = new Button(SelectionLetters.values()[i], SelectionNumbers.values()[y]);
            this.buttons.add(button);}
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

    public String displayOutOfStock(Position position) {
        if(position.getStockLevel() < 1){
            return "Position is out of stock";
        } else return "Position is in stock";
    }

    public String machineNeedsCorrectChange(VendingMachine vendingMachine) {
       if(vendingMachine.EnoughCoinsToGiveChange())
       {return "Correct change only";}
       else return "Can give change";
    }
}
