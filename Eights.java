package com.sowjanya.cards;

import java.util.Scanner;

public class Eights {
	 private Player one;
	    private Player two;
	    private Hand drawPile;
	    private Hand discardPile;
	    private Scanner in;
	    
	    public boolean isDone() {
	        return one.getHand().isEmpty() || two.getHand().isEmpty();
	    }
	    
	    public void reshuffle() {
	        Card prev = discardPile.removeLastCard();
	        discardPile.dealAll(drawPile);
	        discardPile.addCard(prev);
	        drawPile.shuffle();
	    }
	    
	    public Card drawCard() {
	        if (drawPile.isEmpty()) {
	            reshuffle();
	        }
	        return drawPile.removeLastCard();
	    }
	    
	    public Player nextPlayer(Player current) {
	        if (current == one) {
	            return two;
	        } else {
	            return one;
	        }
	    }
	    
	    public void displayState() {
	        one.display();
	        two.display();
	        discardPile.display();
	        System.out.println("Draw pile:");
	        System.out.println(drawPile.size() + " cards");
	        in.nextLine();
	    }
	    
	    public void takeTurn(Player player) {
	        Card prev = discardPile.getLastCard();
	        Card next = player.play(this, prev);
	        discardPile.addCard(next);

	        System.out.println(player.getName() + " plays " + next);
	        System.out.println();
	    }
	    
	    public void playGame() {
	        Player player = one;

	        // keep playing until there's a winner
	        while (!isDone()) {
	            displayState();
	            takeTurn(player);
	            player = nextPlayer(player);
	        }

	        // display the final score
	        one.display();
	        two.display();
	    }

}
