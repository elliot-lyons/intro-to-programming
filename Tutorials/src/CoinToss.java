import java.util.Scanner;
import java.util.Random;

public class CoinToss {
	
	public static boolean HEADS = true;
	public static boolean TAILS = false;
	public static int NUMBER_OF_TRIALS = 10000;					// Explain this please

	public static void main(String[] args) {
		
		Random generator = new Random();
		boolean result = generator.nextBoolean();
		int numberOfHeads = 0;
		int numberOfTails = 0;
		
		for (int trial = 1; trial <= NUMBER_OF_TRIALS; trial++);
		{
			if	(result = true)
			{
				numberOfHeads++;
			}
			
			else
			{
				numberOfTails++;
			}
			
		}
		System.out.println("There were " + numberOfHeads + " heads thrown and " + numberOfTails + 
				"thrown, with the last toss being " + result + ".");
	}

}
