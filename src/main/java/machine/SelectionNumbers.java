package machine;

public enum SelectionNumbers {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);

    private final int number;
    SelectionNumbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
