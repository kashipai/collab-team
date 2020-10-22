package com.sowjanya.cards;

import java.util.Arrays;

public class Card {
	private  int rank;
	private  int suit;
	
	
	public Card(int rank, int suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}
	
    public static final String[] RANKS = {
	        null, "Ace", "2", "3", "4", "5", "6", "7",
	        "8", "9", "10", "Jack", "Queen", "King"};

    public static final String[] SUITS = {
	        "Clubs", "Diamonds", "Hearts", "Spades"};
    
  

    

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}


	@Override
	public String toString() {
		return RANKS[this.rank] + " of " + SUITS[this.suit];
	}
	
	public int compareTo(Card that) {
	    if (this.suit < that.suit) {
	        return -1;
	    }
	    if (this.suit > that.suit) {
	        return 1;
	    }
	    if (this.rank < that.rank) {
	        return -1;
	    }
	    if (this.rank > that.rank) {
	        return 1;
	    }
	    return 0;
	}
	

	public static void printAllCards(Card[] cards) {
		for (Card card : cards) {
	        System.out.println(card);
	    }
		
	}
	
}


