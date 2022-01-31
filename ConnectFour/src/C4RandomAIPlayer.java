import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer {
	
	public C4RandomAIPlayer(int number)
	{
		super(number);
	}
	
	@Override
	public void askColumn()						// generates a random column
	{
		Random generator = new Random();
		int randomInt = generator.nextInt(8);
		
		while (randomInt == 0)
		{
			randomInt = generator.nextInt(8);
		}
		
		System.out.println(randomInt);
		
		setColumn(randomInt);
	}
}
