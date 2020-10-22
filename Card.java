package secondEvaluation;

public class Card {
	public static final String[] Ranks = { null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
			"King" };
	public static final String[] Suits = { "Clubs", "Diamonds", "Hearts", "Spades" };

	private int rank;
	private int suit;

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	public boolean compareCards(Card obj)
	{
		if(getSuit()==obj.getSuit())
			return true;
		if(getRank()==obj.getRank()|| getRank()==8)
			return true;
		return false;
	}

	public boolean equals(Card obj) {
		return rank == obj.rank && suit == obj.suit;
	}

	public String toString() {
		return (Ranks[rank] + " of " + Suits[suit]);
	}

}
