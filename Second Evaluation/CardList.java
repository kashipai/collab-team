package smk.secondevaluation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class CardList 
{
	public static String[] suit;
	public static String[] rank;
	
	private List<Card> deck;

	public CardList()
	{

		deck = new ArrayList<Card>();

		suit = new String[4];
		//String suit[]={"Diamonds", "Clubs", "Spades", "Hearts"};
		suit[0] = "Diamonds";
		suit[1] = "Clubs";
		suit[2] = "Spades";
		suit[3] = "Hearts";

		rank = new String[13];
		rank[0] = "Ace";
		rank[1] = "2";
		rank[2] = "3";
		rank[3] = "4";
		rank[4] = "5";
		rank[5] = "6";
		rank[6] = "7";
		rank[7] = "8";
		rank[8] = "9";
		rank[9] = "10";
		rank[10] = "Jack";
		rank[11] = "Queen";
		rank[12] = "King";

		for (int i = 0; i < 4; i++) 
		{
			for (int k = 0; k < 13; k++)
			{

				deck.add(new Card(rank[k], suit[i]));
			}
		}
	}

	public CardList(List<Card> randomList) 
	{
		deck = randomList;
	}

	public List<Card> getCardList()
	{
		return deck;
	}

	public Card getCard(String rank, String suit) {
		for (Iterator<Card> iterator = deck.iterator(); iterator.hasNext();) {
			Card card = iterator.next();
			if (card.isThis(rank, suit)) {
				return card;
			}

		}
		return null;
	}
	
	public Card getTopCard() {
		if (deck.size() > 0) {
			Card topCard = deck.get(0);
			deck.remove(0);
			return topCard;
		}
		return null;
	}

	
	public static String getRandomSuit(){
		Random rand = new Random();
		int randomNumber = rand.nextInt(4);
		return suit[randomNumber];
	}
}