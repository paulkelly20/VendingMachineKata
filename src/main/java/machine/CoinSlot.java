package machine;

import coins.Coin;
import coins.CoinType;

import java.util.ArrayList;

public class CoinSlot implements CountMoney, CountBalance{
    private ArrayList<Coin> coins;

    public CoinSlot() {
        coins = new ArrayList<>();
    }

    public int countNumberOfCoins() {
        return this.coins.size();
    }

    public Coin addCoin(Coin coin) {
        if (getCoinValue(coin) > 0){
            this.coins.add(coin);
        }

        return coin;
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

    public double getCurrentBalance() {
        double total = 0;

        for (Coin coin : this.coins){
            total += getCoinValue(coin);
        }

        return total;
    }
}
