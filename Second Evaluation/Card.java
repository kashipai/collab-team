package smk.secondevaluation;

public class Card 
{

	public String rank;
	private String suit;
	private boolean used;

	public Card(String rank, String suit) 
	{
		this.suit = suit;
		this.rank = rank;
		used = false;
	}
	
	public void display()
	{
		System.out.println("Card Rank "+rank + " And Suit " + suit);
	}

	public boolean isUsed() 
	{
		return used;
	}
	
	public boolean isThis(String rank, String suit)
	{
		if (rank.equals(this.rank) && (suit.equals(this.suit)))
		{
			return true;
		}
		return false;
	}

	
	public boolean isrank(String rank)
	{
		return this.rank.equals(rank);
	}

	
	public boolean isSuit(Card topCard) 
	{
		return topCard.suit.equals(suit);
	}

	
	public boolean isSuit(String declaredSuit)
	{
		return declaredSuit.equals(suit);
	}

	public boolean isrank(Card topCard)
	{
		return topCard.rank.equals(rank);
	}
	
	public void setUsed(boolean used)
	{
		this.used = used;
	}

}
