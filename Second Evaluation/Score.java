package smk.secondevaluation;

import java.util.List;

public class Score {
	public static int getScore(List<Card> Cardvalue) {
		int i;
		int score = 0;
		for(i=1; i < Cardvalue.size(); i++)
		{
			if((Cardvalue.get(i).rank.equals("Jack"))||(Cardvalue.get(i).rank.equals("Queen"))||(Cardvalue.get(i).rank.equals("King")))
			{
				score+=10;
			}
			else if((Cardvalue.get(i).rank.equals("Ace")))
			{
				score+=1;
			}
			else
			{
				for(int r=2;r<=10;r++)
				{
					int x=Integer.parseInt(Cardvalue.get(i).rank);
					if(x==8)
					{
						score+=20;
					}
					if(x==r)
					{
						score+=x;
					}
				}
			}
		}

		
		return score;

	}
}
