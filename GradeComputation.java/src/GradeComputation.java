import java.util.Scanner;

public class GradeComputation {

	public static final String[] MODULE_CODES   = { "CSU11001", "CSU11010", "CSU11013", 
			"CSU11021", "CSU11022", "CSU11026", "CSU11031", "CSU11081", "CSU12002", "STU11002" };
	public static final int[] MODULE_CREDITS = { 5, 10, 5, 5, 5, 10, 5, 5, 5, 5 };
	public static final int SPECIFIED_FAIL_MARK = 35;
	public static final int FIRST_CLASS_HONOURS_MINIMUM_MARK = 70;
	public static final int TWO_ONE_MINIMUM_MARK = 60; 
	public static final int TWO_TWO_MINIMUM_MARK = 50;
	public static final int THIRD_MINIMUM_MARK = 40;
	public static final int SPECIFIED_MINIMUM_CREDITS = 10;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the first year grade assessor.");
		boolean quit = false;
		Scanner input = new Scanner( System.in );
		int index = 0;
		double[] marks = new double[MODULE_CODES.length];
		
		while ( !quit && index < MODULE_CODES.length )
		{
			System.out.printf("Enter the student mark for %s (or enter quit): ", MODULE_CODES[index]);
			
			if ( input.hasNext("quit") )
			{
				quit = true;
			}
			
			else
			{
				
				if ( input.hasNextDouble() ) 
				{
					double currentMark = input.nextDouble();
					boolean error = error( currentMark );
					
					if ( error )
					{
						System.out.println("Error - Enter a number between 0.0 and 100.0 or quit.");
					}
					
					else
					{
						marks[index] = currentMark;
						index++;	
					}
					
				}
				
				else 
				{
					System.out.println("Error - Enter a number between 0.0 and 100.0 or quit.");
					input.next();
				}
			}
		}
		
		input.close();
		
		if ( !quit )
		{
			String determineOverallGrade = determineOverallGrade( marks );
			double weightedAverageMark = weightedAverageMark( marks );
			int roundedGrade = (int) Math.round(weightedAverageMark);
			int sumOfAllCredits = sumOfCredits( MODULE_CREDITS );
			int creditsBelowSpecifiedMark = creditsBelowSpecifiedMark( marks, sumOfAllCredits );
			
			System.out.println("Result = " + determineOverallGrade + " with an overall mark of " +
					roundedGrade + "%.");
			
			if ( determineOverallGrade == "FAIL" && creditsBelowSpecifiedMark > 0 )
			{
				System.out.println("" + creditsBelowSpecifiedMark + " credits were failed.");
			}
		}

	}
	
	public static boolean error( double number )
	{
		if ( number < 0 || number > 100)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static int creditsBelowSpecifiedMark( double [] marks, int specifiedMinimumMark )
	{
		int creditsBelow= 0;
		
		for ( int index = 0; index < marks.length; index++ )
		{
			double currentResult = marks[index];
			int roundedResult = (int) Math.round(currentResult);
			
			if ( roundedResult < THIRD_MINIMUM_MARK )
			{
				creditsBelow = creditsBelow + MODULE_CREDITS[index];
			}
		}
		
		return creditsBelow;
	}

	public static double weightedAverageMark( double [] marks )
	{
		double creditsReceived = 0;
		int sumOfAllCredits = sumOfCredits( MODULE_CREDITS );
		
		for ( int index = 0; index < marks.length; index++ )
		{
			double percent =  marks[index] / 10;
			creditsReceived = creditsReceived + (percent * MODULE_CREDITS[index]);
		}
		
		return ((creditsReceived / (double) sumOfAllCredits) * 10);	
	  
	}
	
	public static int sumOfCredits ( int[] credits )
	{
		int sumOfCredits = 0;
		
		for ( int index = 0 ; index < credits.length; index++ )
		{
			sumOfCredits = sumOfCredits + credits[index];
		}
		
		return sumOfCredits;
	}
	
	public static boolean failDueToGradeBelowSpecificMark( double[] marks, int specifiedMark)
	{
		boolean fail = false;
		
		for ( int index = 0; index < marks.length && !fail; index++)
		{
			double currentResult = marks[index];
			int roundedResult = (int) Math.round(currentResult);
			
			if ( roundedResult < specifiedMark)
			{
				fail = true;
			}
		}
		return fail;
	}
	
	public static String determineOverallGrade( double[] marks )
	{
		String grade = "";
		double averageGrade = weightedAverageMark( marks );
		int roundedGrade = (int) Math.round(averageGrade);
		boolean failDueToGradeBelowSpecificMark = failDueToGradeBelowSpecificMark( marks, 
				SPECIFIED_FAIL_MARK );
		int sumOfAllCredits = sumOfCredits( MODULE_CREDITS );
		int creditsBelow = creditsBelowSpecifiedMark( marks, sumOfAllCredits );
		
		if ( roundedGrade >= FIRST_CLASS_HONOURS_MINIMUM_MARK )
		{
			grade = "I";
		}
		
		if ( roundedGrade >= TWO_ONE_MINIMUM_MARK && roundedGrade < FIRST_CLASS_HONOURS_MINIMUM_MARK )
		{
			grade = "II.1";
		}
		
		if ( roundedGrade >= TWO_TWO_MINIMUM_MARK && roundedGrade < TWO_ONE_MINIMUM_MARK )
		{
			grade = "II.2";
		}
		
		if ( roundedGrade >= THIRD_MINIMUM_MARK && roundedGrade < TWO_TWO_MINIMUM_MARK )
		{
			grade = "III";
		}
		
		if ( roundedGrade < THIRD_MINIMUM_MARK || failDueToGradeBelowSpecificMark 
				|| creditsBelow > SPECIFIED_MINIMUM_CREDITS )
		{
			grade = "FAIL";
		}
		
		return grade;
	}
}
