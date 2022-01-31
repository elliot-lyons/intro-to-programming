/* SELF ASSESSMENT 
   
1.    createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment: This method intakes the right parameters and returns what it should. It is also named correctly.

Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5: 5
Comment: The method is able to create an array from 2 to n and initialise it too.

Did I return the correct item?
Mark out of 5: 5
Comment: It returned an array from 2 to n ready for use in the rest of the program.


2.    crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 5
Comment: My method is named correctly and uses suitable parameters. It returns nothing as it is void

Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 2
Comment: I made sure the array passed wasn't a null array with an initial if (!null) statement. I've also ensured the index stays within the limits of the array.
I've done this by using an if statement to make sure the index is less than the limit passed - 1

Did I loop through the array using the correct multiple?
Mark out of 5: 5
Comment: My method intakes the correct multiple and cycles through all its higher multiples

Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment: My method crosses out and only crosses out the multiples above it that haven't been crossed out.
Crossed out multiples are represented by being a minus number. The condition for multiples to be crossed out
are that they must be greater than the divisor, which will be positive, and have no remainder when its divided
by the multiple

   
3.    sieve   
Did I have the correct function definition?
Mark out of 5: 5
Comment: My function is appropriately named and has the correct parameters. 

Did I make calls to other methods?
Mark out of 5: 5
Comment: This function calls upon the crossOutHigherMultiples and sequenceToString methods for it to work.     

Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 2 
Comment: The method returns an array that has non-prime numbers crossed out by them being negative.


4.    sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5 
Comment: The method correctly takes in an array and returns a string version of the array

Did I ensure the parameter to be used is not null?
Mark out of 3: 3
Comment: I again check to make sure the array isn't null through an initial if statement 

Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10: 10
Comment:  The string updates itself by adding on the additional numbers, both crossed and not crossed, to the end of the string.
It uses if statements to determine if the numbers need brackets around them. If they are negative, ie not prime, they  will and
if not, they won't have brackets.  


5.    nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5: 5 
Comment: My function correctly takes in an array of prime and composite numbers and returns a string with prime numbers.

Did I ensure the parameter to be used is not null?  
Mark out of 3: 3
Comment: This is done again by an initial if (!null) statement.

Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 5
Comment: The string updates itself adding the non-crossed variables to the string

   
6.    main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5: 5
Comments: The program asks the user for an int >= 2. If this condition isn't met, it returns an error message and asks the user for another input.

Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment: The program calls upon the createSequence, sieve and nonCrossedOutSubseqToString methods within the main function.

Did I print the output as shown in the question?  
Mark out of 5: 5
Comment:  The output is correct as per the sample output on blackboard.


7.    Overall
Is my code indented correctly?
Mark out of 4: 4
Comments: The code is further indented after each "{" as it should be. 

Do my variable names make sense?
Mark out of 4: 4  
Comments: I believe my variable names are easy to understand and make sense.

Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: I believe my variable, method and class names all follow the Java coding standard.


Total Mark out of 100 (Add all the previous marks): 100
*/


import java.util.Scanner;

public class SieveOfEratosthenes {
	
	public static final int LOWER_LIMIT = 2;

	public static void main(String[] args) {
		boolean error = true;
		int upperLimit = 0;
		
		while (error)
		{
			System.out.print("Enter int >= 2: ");
			Scanner input = new Scanner( System.in );
			
			if (input.hasNextInt())
			{
				upperLimit = input.nextInt();
				if (upperLimit >= 2)
				{
					error = false;
				}
			}
			
			if (error) 
			{
				System.out.print("Error. ");
			}
		}
		
		int[] numbers = createSequence(LOWER_LIMIT, upperLimit);
		int []sieve = sieve(numbers, upperLimit);
		String nonCrossedNumbers = nonCrossedOutSubseqToString(sieve);
		System.out.print(nonCrossedNumbers);
	}
	
	private static int[] createSequence(int lower, int higher)
	{
		int currentDigit = lower;
		int index = 0;
		int[] sequence = new int [higher - 1];
		
		while (currentDigit <= higher)
		{
			sequence[index] = currentDigit;
			index++;
			currentDigit++;
		}
		
		return sequence;
	}
	
	private static void crossOutHigherMultiples(int[] sequence, int divisor, int limit)
	{
		if (sequence != null)
		{
			int index = 0;
			
			while (index < limit - 1)
			{
				int currentDigit = sequence[index];
			
				if (currentDigit > divisor && (currentDigit % divisor) == 0)
				{
					sequence[index] = currentDigit * -1;	
				}
				index++;
			}
		}
	}
	
	private static String sequenceToString(int[] sequence)
	{
		int index = 0;
		String sequenceString = "";
		
		if (sequence != null)
		{
			while (index <= (sequence.length - 1))
			{
				int currentDigit = sequence[index];
			
				if (currentDigit < 0)
				{
					sequenceString = sequenceString +"[" + (""  + (currentDigit * -1)) +"]";
				}
			
				else
				{
					sequenceString = sequenceString +("" + currentDigit);
				}
			
				if (index < (sequence.length - 1))
				{
					sequenceString = sequenceString + ", ";
				}
				index++;
			}
		}	
		return sequenceString;
		
	}
	
	private static String nonCrossedOutSubseqToString(int[] sequence)
	{
		int index = 0;
		String nonCrossedString = "";
		int nonCrossLength = 1;
		
		if (sequence != null)
		{
			while (index <= (sequence.length - 1))
			{
				int currentDigit = sequence[index];
			
				if (currentDigit > 0)
				{
					if (nonCrossLength != 1)
					{
						nonCrossedString = nonCrossedString + ", ";
					}
					nonCrossedString = nonCrossedString + ("" + currentDigit);
					nonCrossLength++;
				}
				index++;
			}
		}
		
		return nonCrossedString;
		
	}
	
	private static int[] sieve(int[] sequence, int limit)
	{
		int index = 0;
		
		if (sequence != null)
		{
			while (index <= (sequence.length - 1))
			{	
				int currentNumber = sequence[index];
				crossOutHigherMultiples(sequence, currentNumber, limit);
				String numbersCrossed = sequenceToString(sequence);
			
				System.out.println(numbersCrossed);
				index++;
			}
		}
		return sequence;
	}
}
