import java.util.Random;

public class CardShuffle {

	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	
	public static void main(String[] args) {
		int[] cards = { ACE, 2, 3, 4, 5, 6, 7, 8, 9, 10, JACK, QUEEN, KING };
		int[] shuffledCards = shuffledCards( cards );
		int[] shuffledCardsString = arrayToString( shuffledCards );
		
		System.out.print(shuffledCardsString);
	}
	
		public static int[] shuffledCards( int[] cards)
		{
			int index = 0;
			int temp = cards[index];
			
			if (cards!=null)
			{
				Random generator = new Random();
				while ( index < cards.length )
				{
					int otherIndex = generator.nextInt(cards.length);
					cards[index] = cards[otherIndex];
					cards[otherIndex] = temp;
					index++;
				}
			}
			return cards;
		}
		
		public static void arrayToString( int[] array )
		{
		
		}

}

