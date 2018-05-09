package machine;

import coins.Coin;
import products.Sweet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VendingMachine {
    private CoinSlot coinSlot;
    private ArrayList<Position> positions;
    private KeyPad keyPad;
    private ArrayList<Coin> balance;

    public VendingMachine(CoinSlot coinSlot, KeyPad keyPad, ArrayList<Coin> balance) {
        this.coinSlot = coinSlot;
        this.positions = new ArrayList<>();
        this.keyPad = keyPad;
        this.balance = balance;
        generatePositions();
    }

    private void generatePositions() {
        for (Selection selection: Selection.values()){
           Position position = new Position(0, selection);
           this.positions.add(position);
        }
    }

//    public double getFloat() {
//        return
//    }

    public int getNumberOfPositions() {
        return this.positions.size();
    }
}
