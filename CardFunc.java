package EightsGame;

import java.util.ArrayList;
import java.util.Random;

public class CardFunc {
	private ArrayList<Card> cards;
	private String label;

	public void shuffleDeck() {
		Random random = new Random();

		for (int i = size() - 1; i > 0; i--) {
			int j = random.nextInt(i);
			swapCards(i, j);
		}
	}

	public void swapCards(int i, int j) {
		Card temp = cards.get(i);
		cards.set(i, cards.get(j));
		cards.set(j, temp);
	}

	public void deal(CardFunc cf, int n) {
		for (int i = 0; i < n; i++) {
			Card card = popCard();
			cf.addCard(card);
		}
	}

	public void dealAll(CardFunc cf) {
		int n = size();
		deal(cf, n);
	}

	public String getLabel() {
		return label;
	}

	public Card getCard(int i) {
		return cards.get(i);
	}

	public Card popCard() {
		int i = size() - 1;
		return popCard(i);
	}

	public Card popCard(int i) {
		return cards.remove(i);
	}

	public int size() {
		return cards.size();
	}

	public CardFunc(String label) {
		this.label = label;
		this.cards = new ArrayList<Card>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public boolean empty() {
		return cards.size() == 0;
	}

	public Card last() {
		int i = size() - 1;
		return cards.get(i);
	}

	public String toString() {
		return label + ": " + cards.toString();
	}

}
