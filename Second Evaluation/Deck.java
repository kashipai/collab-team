package javaEvaluation2;

public class Deck extends CardCollection {

	  public Deck(String label) {
	    super(label);
	  }
	  
	  public void addCardsToDeck() {
	    for (int suit = 0; suit <= 3; suit++) {
	      for (int rank = 1; rank <= 13; rank++) {
	        addCard(new Card(rank, suit));
	      }
	    }
	  }
	}
