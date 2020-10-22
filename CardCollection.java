package com.sowjanya.cards;

import java.util.ArrayList;
import java.util.Random;

public class CardCollection {
	private String label;
    private ArrayList<Card> cards;

    public CardCollection(String label) {
        this.label = label;
        this.cards = new ArrayList<Card>();
    }
    
    public String getLabel() {
    	return label;
    }
    public void addCard(Card card) {
        this.cards.add(card);
    }
    
    public Card removeCard(int i) {
        return cards.remove(i);
    }
    
    public Card removeLastCard() {
        int i = cards.size() - 1;    
        return removeCard(i);
    }
    
    public boolean isEmpty() {
        return cards.isEmpty();
    }
    
    public int size() {
        return cards.size();
    }
    
    public Card getCard(int i) {
        return cards.get(i);
        
    }
    
    public Card getLastCard() {
        int i = cards.size() - 1;
        return cards.get(i);
    }
    
    public void shuffle() {
        Random random = new Random();
        for (int i = 52 - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swapCards(i, j);
        }
    }
    
    public void swapCards(int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }
    
    public void deal(CardCollection that, int n) {
        for (int i = 0; i < n; i++) {
            Card card = removeLastCard();
            that.addCard(card);
        }
    }
    
    public void dealAll(CardCollection that) {
        int n = cards.size();
        deal(that, n);
    }

}
