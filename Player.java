package Game;

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

	public Card play(EightsCardGame eights, Card prev) {
		Card card = searchCardForMatch(prev);
		if (card == null) {
			card = drawCardForMatch(eights, prev);
		}
		return card;
	}

	public Card searchCardForMatch(Card prev) {
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.getCard(i);
			if (cardMatching(card, prev)) {
				return hand.popCard(i);
			}
		}
		return null;
	}

	public Card drawCardForMatch(EightsCardGame eights, Card prev) {
		while (true) {
			Card card = eights.draw();
			System.out.println(name + " draws " + card);
			if (cardMatching(card, prev)) {
				return card;
			}
			hand.addCard(card);
		}
	}

	public static boolean cardMatching(Card card1, Card card2) {
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

	public int score() {
		int sum = 0;
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.getCard(i);
			int rank = card.getRank();
			if (rank == 8) {
				sum += 20;
			} else if (rank > 10) {
				sum += 10;
			} else {
				sum += rank;
			}
		}
		return sum;
	}

	public void display() {
		hand.display();
	}

	public void displayFinalScore() {
		System.out.println("Player name :" + name + " has scored  " + score() + " points");
	}

}