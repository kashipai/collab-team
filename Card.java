package EightsGame;

public class Card {

	public static final String[] CardValue = { null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack",
			"Queen", "King" };
	public static final String[] Suit = { "Clubs", "Diamonds", "Hearts", "Spades" };

	private final int value;
	private final int suit;

	public Card(int value, int suit) {
		this.value = value;
		this.suit = suit;
	}

	public int getSuit() {
		return this.suit;
	}

	public boolean equals(Card that) {
		return this.value == that.value && this.suit == that.suit;
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		return CardValue[this.value] + " of " + Suit[this.suit];
	}

}
