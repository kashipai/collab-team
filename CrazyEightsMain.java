package secondEvaluation;

import java.util.ArrayList;
import java.util.Scanner;

public class CrazyEightsMain {
	
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	ArrayList<Player> players = new ArrayList<Player>();
    	System.out.println("Enter the number of Players : ");
        int numOfPlayers = in.nextInt();
        while(numOfPlayers > 4 || numOfPlayers < 2) {
        	if(numOfPlayers > 4) {
        		System.out.println("More than 4 players are not allowed!!!");
        		System.out.println("Please reenter number of player: ");
        		numOfPlayers = in.nextInt();
        	}
        	else {
        		System.out.println("Less than 2 players are not allowed!!!");
        		System.out.println("Please reenter number of player: ");
        		numOfPlayers = in.nextInt();
        	}
        
        }
	    for(int i = 0; i < numOfPlayers; i++ ) {	
	        		System.out.println("Enter the Player name: ");
	        		Player player = new Player(in.next());	        		
	        		players.add(player);
	        		
	    }       
        CrazyEights game = new CrazyEights(players);
        game.playGame();
        
    }
}
