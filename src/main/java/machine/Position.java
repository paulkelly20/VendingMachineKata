package machine;

import products.Product;

import java.util.ArrayList;

public class Position {
    private double price;
    private ArrayList<Product> products;
    private Button button;

    public Position(double price, Button button) {
        this.price = price;
        this.products = new ArrayList<>();
        this.button = button;
    }

    public int getStockLevel() {
        return products.size();
    }

    public double getPrice() {
        return price;
    }

    public Button getButton() {
        return button;
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
