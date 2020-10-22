package com.evaluation.two;

/* program that works just like playing cards
 * game == Crazy_Eights;
 * REPRESENTATIONS ----->
 * (K) --> KING, (Q)--> QUUEN, (J) --> JACK, (A) --> ACE. 
 * (S) --> SPADE, (H) --> HEART, (C) --> CLUB, (D) --> DIAMOND.
 * (X) --> 10.
 * ALL 8 ARE WILD CARDS
 
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class startGame {
	
	
// ---------------------Shuffling of cards before playing -------------------
	
	public static ArrayList<String> shuffle(ArrayList<String> drawPile, int no_of_cards) 
    { 
        Random rand = new Random(); 
        ArrayList<String> 	Temp = new ArrayList<>();  
        Collections.shuffle(drawPile, rand);
        for(int i = 0 ; i < no_of_cards; i++) {
        Temp.add(drawPile.get(0));
        drawPile.remove(0);
        }
        System.out.println(drawPile);          
		return Temp; 
    }
	
//-------------------------- pattern match with player card and open card-----------
	
	public static boolean patternMatch(String pattern[], String playerCard[]) {
		if(pattern[0].equals(playerCard[0]) || pattern[1].equals(playerCard[1])) {
			return true;
		}
		else {
			System.out.println("pattern of your card is not matched");
		}
		return false;
	}
	
//-------------------------- each player turn ----------------------------
	
	private static String startplay(ArrayList<String> players, String open_card, int chance,ArrayList<String> playedCard) {
		int choose;
		Scanner s = new Scanner(System.in);
		System.out.println("OPEN CARD --> " + open_card);
		System.out.println(players);
		System.out.println("enter your card index you want to play");
		choose = s.nextInt();
		String playercard = players.get(choose);
		System.out.println(players);
		String pattern[] = open_card.split("");
		String playerCard[] = playercard.split("");
		if(playerCard[0].equals("8")) {
			playedCard.add(open_card);
			players.remove(choose);
			System.out.println("you choosed wild card--- Now Choose which pattern you want to turn open card");
			System.out.println("1. 8S   2. 8H   3.8C   4.8D");
			int myWildCard = s.nextInt();
			boolean wildcard = false;
			do {
				switch (myWildCard) {			
				case 1: 
				open_card = "8S";
				wildcard = true;
				break;
				
				case 2: 
				open_card = "8H";
				wildcard = true;
				break;
				
				case 3:
				open_card = "8C";
				wildcard = true;
				break;
				
				case 4: 
				open_card = "8D";
				wildcard = true;
				break;
				
				default: System.out.println("invalid choice");
				break;
				}
				
			}while(wildcard == false);

		}
		else if(patternMatch(pattern,playerCard)) {
			open_card = players.remove(choose);
			playedCard.add(open_card);	
		}
		return open_card;
	}
	
	//---------------------calculating final score of each player------------
	
	private static int FinalScores(ArrayList<String> playerDeck) {
		int iterate = playerDeck.size();
		int score = 0;
		for (int i = 0; i < iterate; i++) {
			String card = playerDeck.remove(0);
			String content[] = card.split("");
			if(content[0].equals("K") ||content[0].equals("Q") ||content[0].equals("J")) {
				score = score + 10;
			}
			else if(content[0].equals("8")) {
				score = score + 20;
			}
			else {
				score = score + Integer.parseInt(content[0]);
			}
		}
		return score;
	}
	
//-----------------------------------main program---------------------
	
	public static void main(String[] args) {
		
        int no_of_cards;
        boolean gameEnd = false;
		int chance = 0;
		int count = 0;
        int n;
      
        
		List<String> nameList = Arrays.asList( 
				"AS" , "2S", "3S","4S","5S","6S","7S","8S","9S","XS","JS",
				"QS","KS",
				"AH" , "2H", "3H","4H","5H","6H","7H","8H","9H","XH","JH",
				"QH","KH",
				"AC" , "2C", "3C","4C","5C","6C","7C","8C","9C","XC","JC",
				"QC","KC",
				"AD" , "2D", "3D","4D","5D","6D","7D","8D","9D","XD","JD",
				"QD","KD");
		
		System.out.println("enter number of players");
		ArrayList<String> 	drawPile = new ArrayList<>();
		ArrayList<String> 	playedCard = new ArrayList<>();
		
         
	      
	    drawPile.addAll(nameList);    
	         
	    System.out.println(drawPile);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter number of players");
		n = sc.nextInt();
		
		System.out.println("enter no.of.cards to be given to each player");
		no_of_cards = sc.nextInt();
		startGame player[] = new startGame[n];
		ArrayList<String>[] players = new ArrayList[n]; 
		for(int i = 0; i < n; i++) {
				players[i] = player[i].shuffle(drawPile,no_of_cards);
				
		}
		String open_card = drawPile.get(0);
		drawPile.remove(0);
		System.out.println("--open_card--");
		System.out.println(open_card);
		playedCard.add(open_card);
		System.out.println(" --- START GAME ---");
		do {
			System.out.println("----------------------**********------------------------------------");
			System.out.println("PLAYER ---> "+(chance+1) + " TURN:");
			System.out.println("OPEN CARD IS ==-> "+ open_card);
			System.out.println("--- your cards--");
			System.out.println(players[chance]);
			System.out.println();
			System.out.println("OPTION AVAILABLE FOR A PLAYER -->  " + (chance+1));
			System.out.println();
			System.out.println("CHOOSE  1 --> play a card  AND  2 --> draw a card");
			int ch = sc.nextInt();
			switch(ch) {
				case 1:
				String myCard = open_card;
				open_card = startplay(players[chance],open_card,chance,playedCard);
				if(!myCard.equals(open_card)) {
					chance++;	
				}
				break;
				
				case 2 : 
				System.out.println("drawed  a card");
				players[chance].add(drawPile.remove(0));
				System.out.println(players[chance]);
				if(count<2) {
					count++;
				}
				else {
					count = 0;
					chance++;	
				}
				break;
				
				default: 
				System.out.println("INVALID CHOICE");
				break;
			}
			
			for(int i = 0; i < n; i++) {
				if(players[i].isEmpty()) {
					gameEnd = true;
				}		
			}
			
			//-------> Below condition is to check whether draw pile is empty and recollect all cards from played cards
			
			if(drawPile.isEmpty()) {
				drawPile = (ArrayList<String>) playedCard.clone();
				playedCard.clear();	
				open_card = drawPile.get(0);
			}
			
			//-----------------> to circulate the turns among the players.
			
			if(chance == n) {
				System.out.println();
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("-----------------**********------end of round------************------------");
				System.out.println("--------------------------------------------------------------------------");
				chance = 0;
			}
		}while(gameEnd == false);
		
		//---------------------->to know winner of the game
		
		for(int i = 0; i < n; i++) {
			if(players[i].equals(null)) {
				System.out.println("player"+(i+1)+" is the winner");
			}
		}	
		
		// ------------------->final score of each player
		
		System.out.println("<----------------FINAL SCORES---------------------->");
		for(int i = 0; i < n; i++) {
			int points = FinalScores(players[i]);
			System.out.println(" player - "+ (i + 1) + "is ==-->  "+ points);
		}	
		System.out.println("the players with least score is the winner");
		System.out.println("congrats to player who has least score");
	}
}
