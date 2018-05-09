package machine;

import products.Product;

import java.util.ArrayList;

public class Position {
    private double price;
    private ArrayList<Product> products;
    private Selection selection;

    public Position(double price, Selection selection) {
        this.price = price;
        this.products = new ArrayList<>();
        this.selection = selection;
    }

    public int getStockLevel() {
        return products.size();
    }


}
