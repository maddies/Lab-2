package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	private int iScore;
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand(){
	
	}
	
	public int[] ScoreHand()
	{
		int [] iScore = new int[2];
		
		iScore[0] = 0; 
		iScore[1] = 0; 
		
		Collections.sort(cards);
		
		int oneCardRank;
		
		for (Card c: cards)
		{
			oneCardRank = c.geteRank().getiRankNbr();
			
			switch(oneCardRank) {
			case 14: case 1:
				iScore[0] += 11;
				iScore[1] += 1;
				break;
			case 11: case 12: case 13:
				oneCardRank = 10;
			default:
				iScore[0] += oneCardRank;
				iScore[1] += oneCardRank;
			}
			
			if (iScore[0] != iScore[1]) {
				if(iScore[0] > 21) {
					iScore[0] -= 10;
				}
			}
		}
		
		return iScore;
	}
	
	public void Draw(Deck d)
	{
		this.AddCard(d.draw());
		
	}
	
	private void AddCard(Card c)
	{
		cards.add(c);
	}
}