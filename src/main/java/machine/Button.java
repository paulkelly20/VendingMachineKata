package machine;

public class Button {
    private SelectionLetters selectionletter;
    private SelectionNumbers selectionNumbers;

    public Button(SelectionLetters selectionletter, SelectionNumbers selectionNumbers) {
        this.selectionletter = selectionletter;
        this.selectionNumbers = selectionNumbers;
    }

    public SelectionLetters getSelectionletter() {
        return selectionletter;
    }

    public SelectionNumbers getSelectionNumbers() {
        return selectionNumbers;
    }

    public int getNumberFromSelectionNumbersEnum(){
        return this.selectionNumbers.getNumber();
    }
}
