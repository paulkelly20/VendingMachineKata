package coins;

public enum CoinType {
    FIVEPENCE(3.25, 18.0),
    TENPENCE(6.5, 24.5),
    TWENTYPENCE(5.0, 21.4),
    FIFTYPENCE(8.0, 27.3),
    ONEPOUND(9.5, 22.5),
    TWOPOUND(12.0, 28.4);

    private double weight;
    private double diameter;

    CoinType(double weight, double diameter) {
        this.weight = weight;
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }
}
