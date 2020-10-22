package secondEvaluation;

public class Player {

	private String playerName;
	private CardCollection hand;

	public Player(String name) {
		this.playerName = name;
		hand = new CardCollection(name);
	}

	public String getName() {
		return playerName;
	}

	public CardCollection getHand() {
		return hand;
	}

	public Card play(CrazyEight game, Card prev) {
		Card card = (searchCardsInHand(prev));

		if (card == null) {
			card = drawCardsFromPile(game, prev);
			return card;
		}
		return card;
	}

	public Card searchCardsInHand(Card prev) {
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.getCard(i);
			if (card.compareCards(prev)) {
				return hand.removeCard(i);
			}
		}
		return null;
	}

	public Card drawCardsFromPile(CrazyEight game, Card prev) {
		while (true) {
			Card card = game.draw();
			System.out.println(getName() + " draws " + card);
			if (card.compareCards(prev)) {
				return card;
			}
			hand.addCard(card);
		}
	}

	public int score() {
		int score = 0;
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.getCard(i);
			int rank = card.getRank();
			if (rank == 8) {
				score += 20;
			} else if (rank > 10) {
				score += 10;
			} else {
				score += rank;
			}
		}
		return score;
	}

	public void displayScore() {
		System.out.println(getName() + " --> " + score() + " penalty points");
	}

	public void display() {
		System.out.print(getHand().toString());
	}

}
