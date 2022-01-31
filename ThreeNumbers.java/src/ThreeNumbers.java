/*  SELF ASSESSMENT of whether my code is easy to understand.
   
   1. Did I use easy-to-understand meaningful and properly formatted variable names?
       Mark out of 5: 	5  
       Comment: 		All my variable and constants have easy to understand names and are in the correct format.
   
   2. Did I indent the code appropriately?
       Mark out of 5:   5
       Comment: 		All code is indented as it should be, making it easier to follow.		
   
   3. Did I make use of the functions appropriately within main and the other functions?
       Mark out of 10:  10
       Comment: 		All functions detailed in the assignment are used appropriately.
       
       Total Mark out of  20 (Add all the previous marks):  20
*/



import java.util.Scanner;

public class ThreeNumbers {
	
	public static final double NUMBER_OF_INTEGERS = 3.0;

	public static void main(String[] args) {
		boolean quit = false;
		Scanner input = new Scanner ( System.in );
		
		do
		{
			System.out.println("Please enter your three integers separated by spaces (or enter 'quit'): ");
		
			if (input.hasNext("quit"))
			{
				quit = true;
			}
		
			else
			{
				int integer1 = input.nextInt();
				int integer2 = input.nextInt();
				int integer3 = input.nextInt();
				
				
				int median = medianOf( integer1, integer2, integer3);
				int count = countOfNumbersGreaterThanTheAverage( integer1, integer2, integer3);
		
				System.out.println(getFormattedOutputString( median, count ));
			}
		 
		}
		while (!quit);
		
		input.close();
	}
	
	public static int medianOf( int integer1, int integer2, int integer3)
	{
		int median = 0;
		if ( ((integer1 <= integer2) && (integer1 >= integer3))
				|| ((integer1 >= integer2) && (integer1 <= integer3)) )
		{
			median = integer1;
		}
		if ( ((integer2 >= integer1) && (integer2 <= integer3)) 
				|| ((integer2 <= integer1) && (integer2 >= integer3)) )
		{
			median = integer2;
		}
		if ( ((integer3 >= integer1) && (integer3 <= integer2)) 
				|| ((integer3 <= integer1) && (integer3 >= integer2)) )
		{
			median = integer3;
		}
		return median;
	}
	
	public static double averageOf( int integer1, int integer2, int integer3)
	{
		double sumOfIntegers = ((double) integer1) + ((double) integer2) + ((double) integer3);
		return (sumOfIntegers / NUMBER_OF_INTEGERS);
	}
	
	public static int countOfNumbersGreaterThanTheAverage( int integer1, int integer2, int integer3)
	{
		int count = 0;
		
		if (integer1 > averageOf( integer1, integer2, integer3))
		{
			count = count + 1;
		}
		if (integer2 > averageOf( integer1, integer2, integer3))
		{
			count = count + 1;
		}
		if (integer3 > averageOf( integer1, integer2, integer3))
		{	
			count = count + 1;
		}
		return count;
	}
	
	public static String getFormattedOutputString( int median , int count )
	{
		if ( count >= 2)
		{
			return "The median of your numbers is " 
					+ median 
					+ ", and " 
					+ count 
					+ " of them are greater than their average."; 
		}
		else
		{
			return "The median of your numbers is "
					+ median
					+ ", and " 
					+ count 
					+ " of them is greater than their average."; 
		}
	}	
}
