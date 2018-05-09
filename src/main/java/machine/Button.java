package machine;

public class Button {
    private Selection selection;

    public Button(Selection selection) {
        this.selection = selection;
    }

    public Selection getSelection() {
        return selection;
    }
}
