package machine;

import coins.Coin;
import coins.CoinType;

import java.util.ArrayList;

public class VendingMachine {
    private CoinSlot coinSlot;
    private ArrayList<Position> positions;
    private KeyPad keyPad;
    private ArrayList<Coin> till;



    public VendingMachine( CoinSlot coinSlot, KeyPad keyPad) {
        this.coinSlot = coinSlot;
        this.positions = new ArrayList<>();
        this.keyPad = keyPad;
        this.till = new ArrayList<>();
        generatePositions();
        generateFloat();

    }

    public ArrayList<Coin> getTill() {
        ArrayList<Coin> clone = new ArrayList<>(till);
        return clone;
    }

    public int countNumberOfCoins() {
        return till.size();
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
        till.addAll(floatcoins);

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

    public boolean coinslotBalanceEnoughToBuyProuct(Position position){
        if (position.getStockLevel() >0){
        if(coinSlot.getCurrentBalance() > position.getPrice()){return true;}}
        return false;
    }

    public void addMulitpleCoinsToTill(ArrayList<Coin> coins){
        this.till.addAll(coins);
    }

//    public void sellProduct(Position position){
//        if (coinslotBalanceEnoughToBuyProuct(position)){
//            coinSlot.getCurrentBalance() -= position.getPrice()
//        }

//    }



}
