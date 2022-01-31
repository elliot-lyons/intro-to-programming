import java.util.Scanner;

public class MaxAndMin {

	public static void main(String[] args) {
		double maximumNumber = 0;
		double minimumNumber = 0;
		double pastNumber = 0;
		boolean quit = false;
		Scanner input = new Scanner( System.in);
		
		do
		{
			System.out.print("Enter in a number or 'quit': ");
			
			if (input.hasNextDouble());
			{
				double currentNumber = input.nextDouble();
				
				if (currentNumber >= maximumNumber)
				{
					currentNumber = maximumNumber;
				}
				
				if (currentNumber <= minimumNumber)
				{
					currentNumber = minimumNumber;
				}
				System.out.print("So far the Maximum number is " + maximumNumber + " and the minimum number is " + minimumNumber
						+ ".");
			}
			
			if (input.hasNext("quit"))
				quit = true;
			
			else
			{
				System.out.print("Error. Please enter either a number or 'quit': ");
			}
		
		}
		while (!quit); 
		
		input.close();
		
		System.out.println("Maximum number = " + maximumNumber + "Minimum Number = " + minimumNumber);
		

	}
	
}
