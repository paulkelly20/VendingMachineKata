package machine;

import coins.Coin;
import coins.CoinType;

import java.util.ArrayList;

public class CoinSlot{

    private ArrayList<Coin> coins;

    public CoinSlot() {
        this.coins = new ArrayList<>();
    }

    public int countNumberOfCoins() {
        return coins.size();
    }

    public Coin addCoin(Coin coin) {
        if (coin.getCoinValue() > 0.04){
            this.coins.add(coin);
        }
        return coin;
    }

    public ArrayList<Coin> getCoins() {
        ArrayList<Coin> clone = new ArrayList<>(coins);
        return clone;
    }

    public double getCurrentBalance() {
        double total = 0;

        for (Coin coin : coins ){
            total += coin.getCoinValue();
        }
        return total;
    }


    public ArrayList<Coin> returnAllCoins() {
        ArrayList<Coin> change = new ArrayList<>();
        coins.removeAll(change);
        coins.clear();
        return change;
    }

    public int CoinCoinsReturned(){
        returnAllCoins().size();
    }
}
