package machine;

import products.Product;
import products.Sweet;

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

    public double getPrice() {
        return price;
    }

    public Selection getSelection() {
        return selection;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addStock(Product product) {
        this.products.add(product);
    }


    public Product dispenseProduct() {
        return this.products.remove(0);
    }

    public boolean checkStock(Product product) {
       if (this.products.contains(product)){return true;}
        return false;
    }
}
