package smk.secondevaluation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrawPile 
{
	private CardList shuffledDeck;
	
	
		public DrawPile(CardList deck) 
		{
			List<Card> list = deck.getCardList();
			List<Card> randomList = new ArrayList<Card>();
			while(randomList.size()<52){
				int rand = (int) (Math.random() * 52);
				Card card = list.get(rand);
				if (card.isUsed()) 
				{
					continue;
				}
				card.setUsed(true);
				randomList.add(card);

			}
			shuffledDeck = new CardList(randomList);
		}
	
	public boolean checkAll()
	{
		for (int i = 0; i < 4; i++)
		{
			for (int k = 0; k < 13; k++) 
			{
				Card newcard = shuffledDeck.getCard(CardList.rank[k],
						CardList.suit[i]);
				if (newcard == null)
				{
					return false;
				}
			}
		}
		return true;
	}

	
	public Card getTopCard()
	{
		Card topCard = shuffledDeck.getTopCard();
		return topCard;
		
	}

	public List<Card> dealCards() 
	{
		List<Card> list = new ArrayList<Card>();
		for(int i = 0; i<5; i++){
			Card newCard = getTopCard();
			list.add(newCard);
		}
		return list;
	}

}
