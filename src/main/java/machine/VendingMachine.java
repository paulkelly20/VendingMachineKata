package machine;

import coins.Coin;
import coins.CoinType;
import customer.Customer;
import products.Product;

import java.util.ArrayList;

public class VendingMachine {
    private CoinSlot coinSlot;
    private ArrayList<Position> positions;
    private KeyPad keyPad;
    private ArrayList<Coin> till;
    private ArrayList<Coin> customerChange;


    public VendingMachine(CoinSlot coinSlot, KeyPad keyPad) {
        this.coinSlot = coinSlot;
        this.positions = new ArrayList<>();
        this.keyPad = keyPad;
        this.till = new ArrayList<>();
        this.customerChange = new ArrayList<>();
        generatePositions();
        generateFloat();

    }

    public ArrayList<Coin> getTill() {
        ArrayList<Coin> clone = new ArrayList<>(till);
        return clone;
    }

    public int countNumberOfCoins() {
        return till.size();
    }

    private void generatePositions() {
        for (SelectionLetters selectionLetters : SelectionLetters.values()) {
            for (SelectionNumbers selectionNumbers : SelectionNumbers.values()) {
                Button button = new Button(selectionLetters, selectionNumbers);
                Position position = new Position(0, button);
                this.positions.add(position);
            }
        }
    }


    private void generateFloat() {
        ArrayList<Coin> floatcoins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            floatcoins.add(new Coin(CoinType.TWOPOUND));
            floatcoins.add(new Coin(CoinType.ONEPOUND));
            floatcoins.add(new Coin(CoinType.FIFTYPENCE));
            floatcoins.add(new Coin(CoinType.TWENTYPENCE));
            floatcoins.add(new Coin(CoinType.TENPENCE));
            floatcoins.add(new Coin(CoinType.FIVEPENCE));
        }
        till.addAll(floatcoins);

    }

    public int getNumberOfPositions() {
        return this.positions.size();
    }

    public double getCurrentBalance(ArrayList<Coin> coins) {
        double total = 0;

        for (Coin coin : coins) {
            total += coin.getCoinValue();
        }
        return total;
    }

    public boolean coinslotBalanceEnoughToBuyProuct(Position position) {
        if (position.getStockLevel() > 0) {
            if (coinSlot.getCurrentBalance() > position.getPrice()) {
                return true;
            }
        }
        return false;
    }

    public void addMulitpleCoinsToTill(ArrayList<Coin> coins) {
        this.till.addAll(coins);
    }


    public void sellProduct(Position position, Customer customer) {
        double temporaryBalance = coinSlot.getCurrentBalance();
        if (coinslotBalanceEnoughToBuyProuct(position)) {
            addMulitpleCoinsToTill(coinSlot.coinSlotReleasesAllCoins());
            position.dispenseProduct();
            keyPad.thankYou();
            temporaryBalance -= position.getPrice();
            giveChange(temporaryBalance, customer);
        }
    }

    public double checkCoins(double change, CoinType coinType) {
        if (change >= coinType.getValue()) {
            for (Coin coin : this.till) {
                if (coin.getCoinType() == coinType) {
                    this.till.remove(coin);
                    change -= coinType.getValue();
                    customerChange.add(coin);
                    if (change < coinType.getValue()) break;
                }
            }

        }return change;
    }

    public void giveChange(double change, Customer customer) {
        change = checkCoins(change, CoinType.TWOPOUND);
        change = checkCoins(change, CoinType.ONEPOUND);
        change = checkCoins(change, CoinType.FIFTYPENCE);
        change = checkCoins(change, CoinType.TWENTYPENCE);
        change = checkCoins(change, CoinType.TENPENCE);
        change = checkCoins(change, CoinType.FIVEPENCE);
        customer.addChangeToWallet(customerChange);
    }

        public boolean EnoughCoinsToGiveChange() {
           int twoPound = groupCoinsByType(CoinType.TWOPOUND) ;
            int onePound = groupCoinsByType(CoinType.ONEPOUND);
             int fiftyPence= groupCoinsByType(CoinType.FIFTYPENCE);
             int twentyPence =groupCoinsByType(CoinType.TWENTYPENCE);
           int tenPence = groupCoinsByType(CoinType.TENPENCE);
            int fivePence = groupCoinsByType(CoinType.FIVEPENCE);

        if(twoPound < 2 || onePound < 2 || fiftyPence < 2 || twentyPence < 2 || tenPence < 2 || fivePence < 2){
        return true;
    } return false;
        }

    public int groupCoinsByType(CoinType coinType) {
        int result = 0;
        for (Coin coin : this.till) {
            if (coin.getCoinType() == coinType) {
                result++;
            }
        }return result;

    }

    public void emptyTill() {
        this.till.clear();
    }
}





