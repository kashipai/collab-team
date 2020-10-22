package smk.secondevaluation;

import java.util.ArrayList;
import java.util.List;

public class DiscardPile
{

	
	private List<Card> discardPile;

	public DiscardPile() 
	{
		discardPile = new ArrayList<Card>();
	}
	public void addCard(Card card) 
	{
		discardPile.add(card);
	}

	public Card getTopCard()
	{
		int tops=(discardPile.size())-1;
		return(discardPile.get(tops));
	}
	
}