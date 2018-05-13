package customer;

import coins.Coin;
import machine.CoinSlot;
import products.Product;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Coin> wallet;
    private ArrayList<Product> pocket;

    public Customer(String name, ArrayList<Coin> wallet) {
        this.name = name;
        this.wallet = wallet;
        this.pocket = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int countCoinsInWallet() {
        return wallet.size();
    }

    public int getProductCount() {
        return pocket.size();
    }


    public void addProductToPocket(Product product){
        this.pocket.add(product);
    }


    public Coin giveCoin(Coin coin) {
        this.wallet.remove(coin);
        return coin;
    }

    public void buyProduct(Product product, CoinSlot coinSlot) {
       if(product.getPrice() <= coinSlot.getCurrentBalance()){
           addProductToPocket(product);
       }
    }

    public void addCoinToWallet(Coin coin){
        this.wallet.add(coin);
    }

    public void addChangeToWallet(ArrayList<Coin> change) {
        this.wallet.addAll(change);
    }
}
