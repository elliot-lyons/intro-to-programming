/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful and properly formatted variable names?
       Mark out of 5:   5
       Comment: all my variables have easy to understand names and formatted correctly
    2. Is my code easy to follow/understand?
       Mark out of 5:   5
       Comment: i believe my code is easy to follow as it is indented as it should be 
   3. Did I use the functions as required?
       Mark out of 10:   10
       Comment: all functions required are used and work as they should be 
       Total Mark out of  20 (Add all the previous marks):  20
*/


import java.util.Scanner;

public class PerniciousNumbers {

	public static void main(String[] args) {
		System.out.println("Enter the maximum number you want to consider: ");
		Scanner input = new Scanner( System.in );
		int maxNumber = input.nextInt();
		input.close();
		
		int integer = 0;
		
		if (maxNumber < 0)
		{
			while ( integer >= maxNumber )
			{
				int countBinaryOnes = countBinaryOnes( integer );
				boolean isPernicious = isPernicious( integer );
				String getBinaryString = getBinaryString( integer );
				integer--;
			}
			
		}
		
		else
		{
			while ( integer <= maxNumber)
			{
				int countBinaryOnes = countBinaryOnes( integer );
				boolean isPernicious = isPernicious( integer );
				String getBinaryString = getBinaryString( integer );
			
				if ( isPernicious == true)
				{
					System.out.println(""  + integer + " is a pernicious number as it contains " + countBinaryOnes
							+ " ones in it's binary representation (" + getBinaryString + ")");
				}
				integer++;
			}
		}
	}
	

	public static String getBinaryString( int number)
	{
		int bitCount = numberOfBits( number );
		String getBinaryStringReverse = "";
		String getBinaryString ="";
		
		int stringLength = bitCount;
		int test = number;
		
		if (test == 0)
		{
			getBinaryString = "0";
		}
		
		if (test < 0)
		{
			test = test *-1;
		}
		
		while ( bitCount != 0 )
		{
			int remainder = test % 2;
			test = test / 2;
			getBinaryStringReverse = getBinaryStringReverse + "" + remainder;
			bitCount--;
		}
		
		char[] reverseBinaryCharacters = getBinaryStringReverse.toCharArray();
		
		int index = stringLength - 1;
		
		if ( number < 0)
		{
			getBinaryString = getBinaryString + '-';
			
		}
		
		while ( index >= 0 )
		{		
		getBinaryString = getBinaryString + reverseBinaryCharacters[index];
		index--;
		}
		
		return getBinaryString;
	}
	
	public static int numberOfBits( int number )
	{
		int bitTest = number;
		int bitCount = 0;
		
		for ( ; bitTest != 0; bitCount++)
		{
			bitTest = bitTest / 2;
		}
		return bitCount;
	}
	
	public static int countBinaryOnes( int number )
	{
		String getBinaryString = getBinaryString( number );
		int countBinaryOnes = 0;
		char[] binaryCharacters = getBinaryString.toCharArray(); 
		int bitCount = numberOfBits( number );
		
		if (number < 0)
		{
			bitCount++;
		}
		
		for ( int index1 = 0; index1 < bitCount; index1++)
		{
			if (binaryCharacters[index1] == '1')
			{
				countBinaryOnes++;
			}
		}
		return countBinaryOnes;
		}
	
	public static boolean isPrime( int number)
	{
		boolean isPrimeNumber = true;
		
		if ( number <= 1 )
		{
			isPrimeNumber = false;
		}
		
		else
			{
			for 	( int divisor = number / 2; (divisor > 1) && (isPrimeNumber == true); divisor-- )
			{
				if (number % divisor == 0)
				{
					isPrimeNumber = false;
				}
			}
		}
		return isPrimeNumber;
	}
	
	public static boolean isPernicious( int number )
	{
		int countBinaryOnes = countBinaryOnes( number );
		return isPrime( countBinaryOnes );
	}
}
