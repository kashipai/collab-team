import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand(name);
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void removePlayCard(Card card) {
        for (int i = 0; i < hand.size(); i++) {
            if (card.equals(hand.getCard(i))) {
                hand.popCard(i);
                break;
            }
        }
    }

    public ArrayList<Card> searchForMatch(Card prev) {
        ArrayList<Card> list = new ArrayList();
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            if (cardMatches(card, prev)) {
                list.add(hand.getCard(i));
            }
        }
        return list;
    }

    //Draw one card
    public void drawForMatch(Eights eights, Card prev) {
        Card card = eights.draw();
        System.out.println(name + " draws " + card);
        hand.addCard(card);

    }

    //Checks whether two cards match.
    public static boolean cardMatches(Card card1, Card card2) {
        if (card1.getSuit() == card2.getSuit()) {
            return true;
        }
        if (card1.getRank() == card2.getRank()) {
            return true;
        }
        if (card1.getRank() == 8) {
            return true;
        }
        return false;
    }

    //Calculates the penalty points.
    public int score() {
        int sum = 0;
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            int rank = card.getRank();
            if (rank == 8) {
                sum -= 20;
            } else if (rank > 10) {
                sum -= 10;
            } else {
                sum -= rank;
            }
        }
        return sum;
    }

    //Displays the player's hand.
    public void display() {
        hand.displayWholePile();
    }

    //Displays the player's name and score.
    public void displayScore() {
        int sum = score();
        if (sum == 0) {
            System.out.println("Winner:" + name + " has " + score() + " points");
        } else {
            System.out.println(name + " has " + score() + " points");
        }
    }

}