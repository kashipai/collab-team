package com.sowjanya.cards;

public class main {
	
	public static void main(String[]  args) {
		Deck deck=new Deck("Deck");
		Card card=new Card(11,6);
		Card[] cards = new Card[52];

		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
		    for (int rank = 1; rank <= 13; rank++) {
		       cards[index] = new Card(rank, suit);
		        index++;
		    }
		}
		
		//Card.compareTo(cards,card);
	    Card.printAllCards(cards);
	   
	    deck.shuffle();
	    
	    Hand hand = new Hand("Hand");
	    deck.deal(hand, 5);
	    hand.display();

	    Hand drawPile = new Hand("Draw Pile");
	    deck.dealAll(drawPile);
	    System.out.printf("Draw Pile has %d cards.\n",
	                      drawPile.size());
	    
	    Eights eights=new Eights();
	    Player player=new Player("s");
	    hand.display();
	    player.play(eights,hand.getCard(0));
	    player.searchForMatch(card);
	    player.drawForMatch(eights, card);
	    player.drawForMatch(eights, card);
	    eights.isDone();
	    eights.reshuffle();
	    eights.drawCard();
	    eights.nextPlayer(null);
	    eights.displayState();
	    
	    
	}

	
}