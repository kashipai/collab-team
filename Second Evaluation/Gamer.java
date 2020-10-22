package smk.secondevaluation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gamer 
{

	public String playerName;
	private List<Card> playerHand;

	public Gamer(String playerName) 
	{
		this.playerName = playerName;
		playerHand = new ArrayList<Card>();
	}

	public List<Card> getPlayerHand()
	{
		return playerHand;
	}

	public void setPlayerHand(List<Card> playerHand)
	{
		this.playerHand = playerHand;
	}
	
	public void addCard(Card card)
	{
		playerHand.add(card);
	}

	public void removeCard(Card card) 
	{
		playerHand.remove(card);
	}

	public void printHand() 
	{
		System.out.println();
		System.out.println(playerName + " Has Cards:");
		for (Iterator<Card> iterator = playerHand.iterator(); iterator
				.hasNext();) {
			Card card = iterator.next();
			card.display();
		}

	}

	public Card discard(Card topCard) 
	{
		if (playerHand.size() < 1)
		{
			return null;
		}
		
		if (topCard.isrank("8"))
		{
			String declaredSuit = CardList.getRandomSuit();
			
			
			for (Iterator<Card> iterator = playerHand.iterator(); iterator
					.hasNext();) 
			{
				Card card = iterator.next();
				if (card.isSuit(declaredSuit)) 
				{
					playerHand.remove(card);
					return card;
				}
			}
			return null;
		}
		
		
		for (Iterator<Card> iterator = playerHand.iterator(); iterator
				.hasNext();) 
		{
			Card card = iterator.next();
			if (card.isSuit(topCard))
			{
				playerHand.remove(card);
				return card;
			}
		}
		
		
		for (Iterator<Card> iterator = playerHand.iterator(); iterator
				.hasNext();) 
		{
			Card card = iterator.next();
			if (card.isrank(topCard))
			{
				playerHand.remove(card);
				return card;
			}
		}
		return null;
		
	}
}
