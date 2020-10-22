public class Hand extends CardCollection {

    public Hand(String label) {
        super(label);
    }

    //Prints whole discord pile.
    public void displayWholePile() {
        System.out.println(getLabel() + ": ");
        for (int i = 0; i < size(); i++) {
            System.out.println(getCard(i));
        }
        System.out.println();
    }

    //Prints latest discord card
    public void displaysLatestCard() {
        System.out.println(getLabel() + ": ");
        System.out.println(getCard(size() - 1));
        System.out.println();
    }

}