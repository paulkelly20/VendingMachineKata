package machine;

import coins.Coin;
import coins.CoinType;
import products.Product;
import products.Sweet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VendingMachine {
    private CoinSlot coinSlot;
    private ArrayList<Position> positions;
    private KeyPad keyPad;
    private ArrayList<Coin> coins;



    public VendingMachine( CoinSlot coinSlot, KeyPad keyPad) {
        this.coinSlot = coinSlot;
        this.positions = new ArrayList<>();
        this.keyPad = keyPad;
        this.coins = new ArrayList<>();
        generatePositions();
        generateFloat();

    }

    public ArrayList<Coin> getCoins() {
        ArrayList<Coin> clone = new ArrayList<>(coins);
        return clone;
    }

    public int countNumberOfCoins() {
        return coins.size();
    }

    private void generatePositions() {
        for (Selection selection: Selection.values()){
           Position position = new Position(0, selection);
           this.positions.add(position);
        }
    }


    private void generateFloat(){
        ArrayList<Coin> floatcoins = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            floatcoins.add(new Coin(CoinType.ONEPOUND));
            floatcoins.add(new Coin(CoinType.TWOPOUND));
        }
        coins.addAll(floatcoins);

    }

    public int getNumberOfPositions() {
        return this.positions.size();
    }

    public double getCurrentBalance(ArrayList<Coin> coins) {
        double total = 0;

        for (Coin coin : coins ){
            total += coin.getCoinValue();
        }
        return total;
    }

    public void sellProduct(Product product){
        if(coinSlot.getCurrentBalance() > product.getPrice()){}
    }



}
