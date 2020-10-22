package com.sowjanya.cards;

public class Player {

    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand(name);

}
    
    public CardCollection getHand() {
		return hand;
	}
    
    public String getName() {
		
		return name;
	}
    
    public Card play(Eights eights, Card prev) {
        Card card = searchForMatch(prev);
        if (card == null) {
            card = drawForMatch(eights, prev);
        }
        return card;
    }
    
    public Card searchForMatch(Card prev) {
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            if (cardMatches(card, prev)) {
                return hand.removeCard(i);
            }
        }
        return null;
    }
    
    public Card drawForMatch(Eights eights, Card prev) {
        while (true) {
            Card card = eights.drawCard();
            System.out.println(name + " draws " + card);
            if (cardMatches(card, prev)) {
                return card;
            }
            hand.addCard(card);
        }
    }
    
    public static boolean cardMatches(Card card1, Card card2) {
        return card1.getSuit() == card2.getSuit()
            || card1.getRank() == card2.getRank()
            || card1.getRank() == 8;
    }

	public void display() {
		// TODO Auto-generated method stub
		
	}

	

	
}