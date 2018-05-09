package machine;

import coins.Coin;
import coins.CoinType;

import java.util.ArrayList;

public class CoinSlot extends TillFunction{

    private ArrayList<Coin> coins;

    public CoinSlot() {
        this.coins = new ArrayList<>();
    }

    public int countNumberOfCoins() {
        return coins.size();
    }

    public Coin addCoin(Coin coin) {
        if (getCoinValue(coin) > 0){
            this.coins.add(coin);
        }

        return coin;
    }

    public ArrayList<Coin> getCoins() {
        ArrayList<Coin> clone = new ArrayList<>(coins);
        return clone;
    }


}
