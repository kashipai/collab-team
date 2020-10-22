package EightsGame;

public class Player {
	private String name;
	private Hand hand;

	public Player(String name) {
		this.name = name;
		this.hand = new Hand(name);
	}

	public Hand getHand() {
		return hand;
	}

	public void display() {
		hand.display();
	}

	public Card play(Game game, Card prev) {
		Card card = searchForMatch(prev);
		if (card == null) {
			card = drawForMatch(game, prev);
		}
		return card;
	}

	public Card searchForMatch(Card prev) {
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.getCard(i);
			if (cardMatches(card, prev)) {
				return hand.popCard(i);
			}
		}
		return null;
	}

	public static boolean cardMatches(Card card1, Card card2) {
		if (card1.getSuit() == card2.getSuit()) {
			return true;
		}
		if (card1.getValue() == card2.getValue()) {
			return true;
		}
		if (card1.getValue() == 8) {
			return true;
		}
		return false;
	}

	public Card drawForMatch(Game game, Card prev) {
		while (true) {
			Card card = game.draw();
			System.out.println(name + " draws " + card);
			if (cardMatches(card, prev)) {
				return card;
			}
			hand.addCard(card);
		}
	}

	public String getName() {
		return name;
	}

	public void displayScore() {
		System.out.println(name + " has " + score() + " points");
	}

	public int score() {
		int sum = 0;
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.getCard(i);
			int value = card.getValue();
			if (value == 8) {
				sum -= 20;
			} else if (value > 10) {
				sum -= 10;
			} else {
				sum -= value;
			}
		}
		return sum;
	}

}
