package javaEvaluation2;

public class Card {

	  public static final String[] Ranks = {
	      null, "Ace", "2", "3", "4", "5", "6", "7",
	      "8", "9", "10", "Jack", "Queen", "King"};
	  public static final String[] Suits = {
	      "Clubs", "Diamonds", "Hearts", "Spades"};

	  private final int rank;
	  private final int suit;

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

	  public String toString() {
	    return Ranks[rank] + " of " + Suits[suit]; 
	  }

	  public boolean equals(Card that) {
	    return rank == that.rank
	        && suit == that.suit;
	  }

	  public int compareValueALSD(Card that) {
	    if (suit < that.suit) {
	      return -1;
	    }
	    if (suit > that.suit) {
	      return 1;
	    }
	    if (rank < that.rank) {
	      return -1;
	    }
	    if (rank > that.rank) {
	      return 1;
	    }
	    return 0;
	  }

	  public int compareValueAHSD(Card that) {
	    if (suit < that.suit) {
	      return -1;
	    }
	    if (suit > that.suit) {
	      return 1;
	    }
	    if (this.rank == 1 && that.rank != 1) {
	      return 1;
	    }
	    if (rank < that.rank) {
	      return -1;
	    }
	    if (rank > that.rank) {
	      return 1;
	    }
	    return 0;
	  }

	  }

