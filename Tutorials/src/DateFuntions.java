import java.util.Scanner;

public class DateFuntions {

	public static void main(String[] args) {
	
		System.out.println("Enter a date (e.g. 24): ");
		Scanner input = new Scanner ( System.in );
		int date = input.nextInt();
		
		System.out.print("Enter a number representing a month (e.g. 1 for January): ");
		int month = input.nextInt();
		
		System.out.print("Enter a year: ");
		int year = input.nextInt();
		
	
		if	( validDate( date, month, year ) == true )
		{
			System.out.println("Date is valid.");
		}
		else
		{
			System.out.println("Date is not valid.");
		}
		
		
		System.out.printf("There are %d days that month.%n", daysInMonth( month, year ));
		
		
		if ( isLeapYear( year ) == true )
		{
			System.out.printf("The year %d is a leap year.", year);
		}
		
		else
		{
			System.out.printf("The year %d is not a leap year.", year);
		}
		
	}
	
	private static boolean validDate( int date, int month, int year )
	{
		if ( (date <1 && date > 31) || (month < 1 && month > 12) || (year < 0) )
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	private static int daysInMonth( int month, int year )
	{
		switch ( month )
		{
		case 2:
				if ( isLeapYear( year ) == true )
				{
					return 29;
				}
				else
				{
					return 28;
				}
		case 4:
			
		case 6:
			
		case 9:
			
		case 11:
				return 30;
			
		default:
				return 31;
		
		}	
	}
	
	private static boolean isLeapYear( int year )
	{
		if ((year % 400 == 0) ||
				((year % 4 == 0) && (year % 100 != 0)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
	
