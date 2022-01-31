/*  SELF ASSESSMENT of whether my code is easy to understand.
   
   1. Did I use easy-to-understand meaningful variable and constant names?
       Mark out of 10:	10   
       Comment:		I believe all my variable names are easy to interpret 
   
   2. Did I format the variable and constant names properly (in lowerCamelCase and UPPERCASE)?
       Mark out of 5:   5
       Comment: No constants were used and the variables are all in lowerCamelCase
   
   3. Did I indent the code appropriately?
       Mark out of 10:	10   
       Comment: 	All code is indented correctly and hence easy to follow
   
   4. Did I implement a for loop to read the input as required?
       Mark out of 10:   10
       Comment: A for loop is used and is working as it should be.
   
      Total Mark out of  35 (Add all the previous marks):  
*/


import java.util.Scanner;

public class TotalAverageCalculator {

	public static void main(String[] args) {
		System.out.print("How many integers do you want to enter? ");
		Scanner input = new Scanner ( System.in );
		int numberOfIntegers = input.nextInt();
		
		double average = 0;
		double sum = 0;
		
		if (numberOfIntegers < 2 || numberOfIntegers > 10)
		{
			System.out.println("Error: This program is constrained to only compute the total & average of between "
					+ "2 & 10 integers.");
		}
		
		else
		{
			for (double currentNumberOfIntegers = 1; numberOfIntegers > 0; numberOfIntegers = numberOfIntegers - 1)
			{	
				System.out.printf("Enter integer %.0f: ", currentNumberOfIntegers);
				int currentInteger = input.nextInt();
			
				sum += currentInteger;
				average = sum / currentNumberOfIntegers++;
			}
		
			System.out.printf("The sum of your integers is %.0f and the average is %.2f. " , sum, average);
		
		}
		
	}
	
}
