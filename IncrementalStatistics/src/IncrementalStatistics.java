/*  SELF ASSESSMENT of whether my code is easy to understand.
   
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5:	5   
       Comment:	I think all my variable names are easy to understand.
   
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:	5   
       Comment:	All variable names were properly formatted. 
   
   3. Did I indent the code appropriately?
       Mark out of 5:	5   
       Comment:	All code is indented as it should be.

   4. Did I implement a while loop or do-while loop as required?
       Mark out of 10:	10   
       Comment:	I used a do-while loop and it worked successfully.
      
      Total Mark out of  25 (Add all the previous marks):	25  
*/


import java.util.Scanner;

public class IncrementalStatistics {

	public static void main(String[] args) {
		int count = 1;
		double average = 0;
		double variance = 0;
		double pastNumber = 0;
		boolean exit = false;
		Scanner input = new Scanner ( System.in );
		
		System.out.println("This program computes the average and variance of all numbers entered.");
		
		do
		{
			System.out.print("Enter a number (or type 'exit'): ");
			
			if (input.hasNextDouble())
			{
				double currentNumber = input.nextDouble();
				double pastAverage = average;
				
				average = pastAverage + ((currentNumber - pastAverage) / count);
				
				variance = (((count - 1) * variance) + (currentNumber - pastAverage) * (currentNumber - average)) / count;
				
				System.out.printf("So far the average is %.1f and the variance is %.1f. \n" , average, variance);
				
				pastNumber = currentNumber;
				count = count + 1;
			}
			
			else if (input.hasNext("exit"))
				exit = true;
			
			else
			{
				System.out.println("Error:  You must enter a real number (e.g. 12.5) \n");
				input.next();
			}
				
		
		} while (!exit);
		input.close();
		
		System.out.println("Goodbye.");

	}

}
