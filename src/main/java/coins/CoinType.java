package coins;

public enum CoinType {
    ONEPENCE(1.0, 1.0, 0.01),
    FIVEPENCE(3.25, 18.0, 0.05),
    TENPENCE(6.5, 24.5, 0.10),
    TWENTYPENCE(5.0, 21.4, 0.20),
    FIFTYPENCE(8.0, 27.3, 0.50),
    ONEPOUND(9.5, 22.5, 1.00),
    TWOPOUND(12.0, 28.4, 2.00);

    private double weight;
    private double diameter;
    private double value;

    CoinType(double weight, double diameter, double value) {
        this.weight = weight;
        this.diameter = diameter;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public double getDiameter() {
        return diameter;
    }
}
