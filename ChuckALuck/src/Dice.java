
public class Dice {

	private final int SIDES;
	private int topFace;
	
	public Dice(int n)
	{
		if (n <= 1)
		{
			SIDES = 2;
		}
		
		else
		{
			SIDES = n;
		}
	}
	
	public Dice()
	{
		SIDES = 6;
	}
	
	public int topFace()
	{
		return topFace;
	}
	
	public int roll()
	{
		topFace = (int)(Math.random() * SIDES) + 1;
		return topFace;
	}
	
	public String toString(int x)
	{
		return "Dice " + x + "has " + SIDES + "sides. The showing side is " + topFace;
	}

	

}
