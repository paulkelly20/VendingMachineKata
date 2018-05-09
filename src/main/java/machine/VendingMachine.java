package machine;

import coins.Coin;
import coins.CoinType;
import products.Sweet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VendingMachine implements CountMoney, CountBalance{
    private CoinSlot coinSlot;
    private ArrayList<Position> positions;
    private KeyPad keyPad;
    private ArrayList<Coin> coins;

    public VendingMachine(CoinSlot coinSlot, KeyPad keyPad, ArrayList<Coin> coins) {
        this.coinSlot = coinSlot;
        this.positions = new ArrayList<>();
        this.keyPad = keyPad;
        this.coins = coins;
        generatePositions();
    }

    private void generatePositions() {
        for (Selection selection: Selection.values()){
           Position position = new Position(0, selection);
           this.positions.add(position);
        }
    }

    public double getCurrentBalance() {
        double total = 0;

        for (Coin coin : this.coins){
            total += getCoinValue(coin);
        }

        return total;
    }

    public double getCoinValue(Coin coin){
        if (coin.getWeightFromEnum() == CoinType.FIVEPENCE.getWeight() && coin.getCoinDiameter() == CoinType.FIVEPENCE.getDiameter()){
            return 0.05;
        }

        if (coin.getWeightFromEnum() == CoinType.TENPENCE.getWeight() && coin.getCoinDiameter() == CoinType.TENPENCE.getDiameter()){
            return 0.10;
        }

        if (coin.getWeightFromEnum() == CoinType.TWENTYPENCE.getWeight() && coin.getCoinDiameter() == CoinType.TWENTYPENCE.getDiameter()){
            return 0.20;
        }

        if (coin.getWeightFromEnum() == CoinType.FIFTYPENCE.getWeight() && coin.getCoinDiameter() == CoinType.FIFTYPENCE.getDiameter()){
            return 0.50;
        }

        if (coin.getWeightFromEnum() == CoinType.ONEPOUND.getWeight() && coin.getCoinDiameter() == CoinType.ONEPOUND.getDiameter()){
            return 1.00;
        }

        if (coin.getWeightFromEnum() == CoinType.TWOPOUND.getWeight() && coin.getCoinDiameter() == CoinType.TWOPOUND.getDiameter()){
            return 2.00;
        }

        return 0;
    }

    public int getNumberOfPositions() {
        return this.positions.size();
    }
}
