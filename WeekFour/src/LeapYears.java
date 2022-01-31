import java.util.Scanner;

public class LeapYears {

	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );
		System.out.print("Enter the first year: ");
		int firstYear = input.nextInt();

		System.out.print("Enter the last year: ");
		int lastYear = input.nextInt();

		for (int year=firstYear; (year <= lastYear); year++)
		{
			if ((year % 400 == 0) ||
					((year % 4 == 0) && (year % 100 != 0)))
			{
				System.out.println( "" + year + " is a leap year." );
			}
		}
	}
}
