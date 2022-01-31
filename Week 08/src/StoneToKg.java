import java.util.Scanner;

public class StoneToKg {
	
		public static final int OUNCES_IN_A_POUND = 16;
		public static final int POUNDS_IN_A_STONE = 14;
		public static final double KILOGRAMS_IN_AN_OUNCE = 0.02834952;

	public static void main(String[] args) {
		boolean quit = false;
		Scanner input = new Scanner( System.in );
		
		while (!quit)
		{
			
			System.out.println("Enter the number of stones, pounds and ounces seperated by spaces (or enter quit): ");
			
			if (input.hasNext("quit"))
			{
				quit = true;
			}
		
			else
			{
				int stones = input.nextInt();
				int pounds = input.nextInt();
				int ounces = input.nextInt();
				
				double kilograms = convertToKilograms( stones, pounds, ounces); 
				
			}
			
			
				
			
		}
		input.close();
		

	}
	
	public static double convertToKilograms( int stones, int pounds, int ounces)
	{
		double totalOunces = ounces + (stones * 224) + (pounds * 16);
		return totalOunces * 0.02834952;
	}
	
	public static String getFormattedWeightString( double kilograms, int stones, int pounds, int ounces )
	{
		if (kilograms == 0)
		{
			return "0 ounces is equal to 0.0kg";
		}
		
	}
	}

