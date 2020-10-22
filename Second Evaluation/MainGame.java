package smk.secondevaluation;

import java.util.List;
import java.util.Scanner;

public class MainGame
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		CardList deck = new CardList();
		
		DrawPile shuffledDeck = new DrawPile(deck);
		
		
		System.out.println("Enter Player 1 Name :- ");
		String  playerOneName=sc.next();
		Gamer playerOne = new Gamer(playerOneName);
		
		System.out.println("Enter Player 2 Name :- ");
		String playerTwoName=sc.next();
		Gamer playerTwo = new Gamer(playerTwoName);

		List<Card> listForPlayerOne = shuffledDeck.dealCards();
		playerOne.setPlayerHand(listForPlayerOne);

		List<Card> listForPlayerTwo = shuffledDeck.dealCards();
		playerTwo.setPlayerHand(listForPlayerTwo);
		
		playerOne.printHand();
		playerTwo.printHand();

		
		DiscardPile discardPile = new DiscardPile();
		Card faceUpCard = shuffledDeck.getTopCard();
		discardPile.addCard(faceUpCard);
		faceUpCard.display();
		System.out.println("");
		System.out.println("Game Starts!");
		
		 
		while (true) {
			playerOne.printHand();
			Card newCard = shuffledDeck.getTopCard();
			if (newCard == null) {
				System.out.println("");
				System.out.println("No cards left in deck. GAME OVER.");
				int playerOneScore = Score.getScore(listForPlayerOne);
				int playerTwoScore = Score.getScore(listForPlayerTwo);
				System.out.println("Player one's score is "+playerOneScore);
				System.out.println("Player two's score is "+playerTwoScore);
				break;
			}
			if (newCard != null) 
			{
				System.out.print("You have pulled out ");
				newCard.display();
				playerOne.addCard(newCard);
				Card topCard = discardPile.getTopCard();
				
				if (topCard != null)
				{
					System.out.print("Top card on discard pile is: ");
					topCard.display();

					Card discardedCard = playerOne.discard(topCard);
					if (discardedCard != null) 
					{
						discardPile.addCard(discardedCard);
						System.out.print(playerOneName + " discarded ");
						discardedCard.display();
					}
					
				} 
				
				else 
				{
					System.out.println("Error: Discard pile is empty.");
					break;
				}
			}
			playerTwo.printHand();
			Card newCardTwo = shuffledDeck.getTopCard();
			
			if (newCardTwo == null)
			{
				System.out.println("\nNo cards left in deck. GAME OVER.");;
				int playerOneScore = Score.getScore(listForPlayerOne);
				int playerTwoScore = Score.getScore(listForPlayerTwo);
				System.out.println("Player one's score is "+playerOneScore);
				System.out.println("Player two's score is "+playerTwoScore);
				break;
			}
			
			if (newCardTwo != null)
			{
				System.out.print("You Pulled Out  ");
				newCardTwo.display();
				playerTwo.addCard(newCardTwo);

				Card topCard = discardPile.getTopCard();
				
				if (topCard != null)
				{
					System.out.print("Top card on discard pile is: ");
					topCard.display();

					Card discardedCard = playerTwo.discard(topCard);
					if (discardedCard != null) 
					{
						discardPile.addCard(discardedCard);
						System.out.print(playerTwoName + " discarded ");
						discardedCard.display();
					}
				} 
				
				else 
				{
					System.out.println("Error: Discard pile is empty.");
					break;
				}
			}

		}
		
	}
}