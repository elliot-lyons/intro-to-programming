import java.util.Scanner;

public class Median {

	public static void main(String[] args) {
		System.out.println("Welcome to the median & rolling average system.");
		boolean quit = false;
		double count = 1;
		double[] numbers = null;
		Scanner input = new Scanner( System.in );
		
		while( !quit )
		{
			System.out.println( "Enter a number (or enter quit):" );
			
			if ( input.hasNext("quit") )
			{
				quit = true;
			}
		
			else
			{
				if ( input.hasNextDouble() )
				{
					double count1 = count;
					
					if ( count > 3)
					{
						count1 = 3;
					}
					
					double currentNumber = input.nextDouble();
					double[] newNumbers = new double[ (numbers == null) ? 1 : numbers.length + 1 ];
				
					if ( numbers != null )
					{
						System.arraycopy( numbers, 0, newNumbers, 0, numbers.length );
					}
				
					newNumbers[ newNumbers.length - 1] = currentNumber;
					numbers = newNumbers;
					
					double rollingAverage = computeRollingAverage( numbers, count1 );
					String numbersToString = convertToString( numbers );
					double median = computeMedian( numbers );
					
					System.out.printf("The median of %s is %.1f and the rolling average "
							+ "of the last 3 values is %.1f. %n", numbersToString, median, rollingAverage);
					
					count++;
					
				}
				else
				{
					System.out.println( "Error - Enter any real number or quit." );
					input.next();
				}
			}
		}
		input.close();
	}
	
	public static double computeMedian( double[] array )
	{
		double[] sortedArray = createSortedArray( array ); 
		double median = 0;
		boolean empty = empty( array );
		
		if ( !empty )
		{
			if ( sortedArray.length % 2 == 1)
			{
				median = sortedArray[sortedArray.length / 2];
			}
		
			else
			{
				int index2 = sortedArray.length / 2;
				int index1 = index2 - 1;
			
				median = ( sortedArray[index1] + sortedArray[index2] ) / 2;
			}
		}
		return median;
	}
	
	public static double[] createSortedArray( double[] array )
	{
		boolean empty = empty( array );
		if ( !empty )
		{
			double[] sortedArray = new double[array.length];
			System.arraycopy( array, 0, sortedArray, 0, array.length );
			
			for ( int index = 0; index < array.length - 1; index++ )
			{
				int minimumIndex = index;
				
				for ( int index2 = index + 1; index2 < array.length; index2++ )
				{
					if ( sortedArray[index2] < sortedArray[minimumIndex] )
						minimumIndex = index2;
				}
				
				double temp = sortedArray[index];
				sortedArray[index] = sortedArray[minimumIndex];
				sortedArray[minimumIndex] = temp;
			}
			return sortedArray;
		}
		else
		{
			return array;
		}
		
	}
	
	public static double computeRollingAverage( double[] array, double count )
	{
		double sum = 0;
		double average = 0;
		int count1 = (int) count;
		
		if ( count1 > array.length )
		{
			count1 = array.length;
		}
		
		int count2 = count1;
		
		if ( array != null )
		{
			if ( count == 0 )
			{
				average = 0;
			}
			else
			{
				while ( count1 >= 1 )
				{		
					int index = array.length - count1;
					sum = sum + array[index];
					count1--;
				}
				
				average = sum / ( count2 );
			}
			
		}
		return average;
	}
	
	public static String convertToString( double[] array )
	{
		String arrayToString = "{ ";
		boolean empty = empty( array );
		
		if ( empty )
		{
			arrayToString = arrayToString + "}";
		}
		
		else
		{
			for ( int index = 0; index < array.length; index++)
			{
				double number = array[index];
				String arrayToString1 = String.format("%.1f", number);
				arrayToString = arrayToString + arrayToString1
						+ ((index == array.length - 1) ? " }" : ", ");
			}
				
		}
		
		return arrayToString;
	}
	
	public static boolean empty( double[] array )
	{
		boolean empty = true;
		String arrayToString = "";
		
		if( array != null )
		{
			for ( int index = 0; index < array.length && empty; index++ )
			{
				arrayToString = arrayToString + array[index];
			}
			
			if ( arrayToString != "")
			{
				empty = false;
			}
		}
		return empty;
	}
		
}
