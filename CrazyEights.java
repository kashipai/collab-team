package secondEvaluation;

import java.util.ArrayList;
import java.util.Scanner;

public class CrazyEights {
    private Hand drawPile;
    private Hand discardPile;
    Scanner in = new Scanner(System.in);;
    ArrayList< Player> players = new ArrayList<>();
    int handSize = 5;   
    public CrazyEights(ArrayList< Player> playersList ) {    	
    	
        Deck deck = new Deck("Deck");
        deck.shuffle();
        
        for(Player p1 : playersList) {
        	players.add(p1);
        }     
        for(int i = 0; i < players.size(); i++) {
        	deck.deal(players.get(i).getHand(),handSize);
        }
        // turn one card face up
        discardPile = new Hand("Discards");
        deck.deal(discardPile, 1);

        // put the rest of the deck face down
        drawPile = new Hand("Draw pile");
        deck.dealAll(drawPile);

        // create the scanner we'll use to wait for the user
        in = new Scanner(System.in);
    }

    public void displayState() {
    	for(Player player : players) {
    		player.display();
    	}
        discardPile.display();
        System.out.print("Draw pile: ");
        System.out.println(drawPile.size() + " cards");
    }

    public boolean isDone() {  
        boolean handEmpty = false;
    	for(Player player : players) {
    		if(player.getHand().empty()) {
    			  handEmpty = true;
    			  return handEmpty;    			 
    		}
    	}
        return handEmpty;
    }

    public void reshuffle() {
        // save the top card
        Card prev = discardPile.popCard();

        // move the rest of the cards
        discardPile.dealAll(drawPile);

        // put the top card back
        discardPile.addCard(prev);

        // shuffle the draw pile
        drawPile.shuffle();
    }

    public void takeTurn(Player player) {
        Card prev = discardPile.last();
        Card next = player.play(this, prev);

        System.out.println(player.getName() + " plays " + next);
        System.out.println();

        discardPile.addCard(next);
    }
    
    public Card draw() {
        if (drawPile.empty()) {
            reshuffle();
        }
        return drawPile.popCard();
    }
    
    public void waitForUser() {
        in.nextLine();
    }
    
    public Player nextPlayer(Player current) {
    	Player nextPlayer = null;
    	for (int i = 0; i < players.size(); i++) {
    		if(current == players.get(i)) {
    			if(i < players.size()-1) {
    			nextPlayer = players.get(i+1);
    		    }
    		   else {
    			nextPlayer = players.get(0);
    		   }   
    		}
    	}
    	return nextPlayer;
    }
    public void winner() {
		for(Player player : players) {
			if(player.score() == 0) {
				System.out.println( player.getName()+" is the winner!!!");
			}
		}
    }
    public void playGame() {
        Player player = players.get(0);

        // keep playing until there's a winner
        while (!isDone()) {
            displayState();
            waitForUser();
            takeTurn(player);
            player = nextPlayer(player);
        }
        winner();
        // display the final score
        for (Player playerScore: players) {
        	
        	playerScore.displayScore();
        }
    }

    
}
