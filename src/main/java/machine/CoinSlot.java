package machine;

import coins.Coin;

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
}
