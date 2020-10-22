package javaEvaluation2;

public class Hand extends Player {

	  private CardCollection eightsHand;

	  public Hand(String name) {
	    super(name);
	    eightsHand = new CardCollection(name);
	  }
	  
	  public CardCollection getHand()
	  {
		  return eightsHand;
	  }

	  public Pile play(CrazyEights crazyEights, Pile prev) {
	    Pile ecard = new Pile(0, 0);
	    ecard = ecard.convert(searchForMatch(prev));

	    if (ecard == null) {

	      ecard = drawForMatch(crazyEights, prev);
	      return ecard;
	    }
	    return ecard;
	  }

	  /**
	   * Searches the player's hand for a matching card.
	   */
	  public Card searchForMatch(Pile prev) {
	    for (int i = 0; i < eightsHand.size(); i++) {
	      Card card = eightsHand.getCard(i);
	      Pile ecard = new Pile(0,0);
	          ecard = ecard.convert(card);
	      if (ecard.cardMatches(prev)) {
	        return eightsHand.popCard(i);
	      }
	    }
	    return null;
	  }

	  /**
	   * Draws cards until a match is found.
	   */
	  public Pile drawForMatch(CrazyEights crazyEights, Pile prev) {
	    while (true) {
	      Pile card = crazyEights.draw();
	      System.out.println(getName() + " draws " + card);
	      if (card.cardMatches(prev)) {
	        return card;
	      }
	      eightsHand.addCard(card);
	    }
	  }


	  public int score() {
	    int sum = 0;
	    for (int i = 0; i < eightsHand.size(); i++) {
	      Card card = eightsHand.getCard(i);
	      int rank = card.getRank();
	      if (rank == 8) {
	        sum -= 20;
	      } else if (rank > 10) {
	        sum -= 10;
	      } else {
	        sum -= rank;
	      }
	    }
	    return sum;
	  }


	  public void displayWinner() {
	   
	    if(score() == 0)
	    {
	    	System.out.println(getName() +" is the Winner.!");
	    }
	    
	  }
	  
	  public void displayScores()
	  {
		  System.out.println(getName()+" scored "+ score()+" points\n");
	  }

	  public void display() {
	    getHand().display();
	  }

	}
