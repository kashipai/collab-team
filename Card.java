package Game;

public class Card {
	public static final String[] RANKS = { null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
			"King" };

	public static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };

	private final int rank;

	private final int suit;

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return this.rank;
	}

	public int getSuit() {
		return this.suit;
	}

	public String toString() {
		return RANKS[this.rank] + " of " + SUITS[this.suit];
	}

}
