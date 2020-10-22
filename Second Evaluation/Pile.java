package javaEvaluation2;

public class Pile extends Card {

	  public Pile(int rank, int suit) {
	    super(rank, suit);

	  }

	  public boolean cardMatches(Pile that) {
	    if (getSuit() == that.getSuit()) {
	      return true;
	    }
	    if (getRank() == that.getRank()) {
	      return true;
	    }
	    if (getRank() == 8) {
	      return true;
	    }
	    return false;
	  }


	  public Pile convert(Card card) {
	    if (card != null) {
	    Pile result = new Pile(card.getRank(), card.getSuit());
	    return result;
	    } 
	    return null;
	  }
	}

