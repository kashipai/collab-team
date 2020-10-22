package secondEvaluation;

import java.util.ArrayList;
import java.util.Random;

public class CardCollection {

	private String type;
	private ArrayList<Card> cards;

	public CardCollection(String type) {
		this.type = type;
		this.cards = new ArrayList<Card>();
	}

	public String getType() {
		return type;
	}

	public Card getCard(int i) {
		return cards.get(i);
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public int size() {
		return cards.size();
	}
	
	public Card lastCard() {
		return cards.get(size() - 1);
	}
	
	public Card removeCard(int i) {
		return cards.remove(i);
	}

	public Card removeLastCard() {
		return removeCard(size() - 1);
	}

	public void deal(CardCollection obj, int n) {
		for (int i = 0; i < n; i++) {
			Card card = removeLastCard();
			obj.addCard(card);
		}
	}

	public void dealAll(CardCollection obj) {
		int n = size();
		deal(obj, n);
	}

	public void swapCards(int i, int j) {
		Card temp = cards.get(i);
		cards.set(i, cards.get(j));
		cards.set(j, temp);
	}

	public void shuffle() {
		Random random = new Random();
		for (int i = size() - 1; i > 0 ; i--) {
			int j = random.nextInt(i);
			swapCards(i, j);
		}
	}

	public String toString() {
		return (type + ": " + cards.toString())+"\n";
	}
	
}