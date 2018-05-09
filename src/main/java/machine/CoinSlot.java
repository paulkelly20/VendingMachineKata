package machine;

import coins.Coin;
import coins.CoinType;

import java.util.ArrayList;

public class CoinSlot {
    private ArrayList<Coin> coins;

    public CoinSlot() {
        coins = new ArrayList<>();
    }

    public int countNumberOfCoins() {
        return this.coins.size();
    }

    public void addCoin(Coin coin) {
        this.coins.add(coin);
    }

//    FIVEPENCE(3.25, 18.0),
//    TENPENCE(6.5, 24.5),
//    TWENTYPENCE(5.0, 21.4),
//    FIFTYPENCE(8.0, 27.3),
//    ONEPOUND(9.5, 22.5),
//    TWOPOUND(12.0, 28.4);

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

//    public double coinsValue() {
//
//        for each of the coins in our coins arraylist
//
//    }
}
