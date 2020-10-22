package secondEvaluation;

public class Card {
    private int rank;
    private int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }
    

	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public int getSuit() {
		return suit;
	}


	public void setSuit(int suit) {
		this.suit = suit;
	}


	public String toString() {
	    String[] ranks = {null, "Ace", "2", "3", "4", "5", "6","7", "8", "9", "10", "Jack", "Queen", "King"};
	    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	    String card = ranks[this.rank] + " of " + suits[this.suit];
	    return card;
	}
	
}
