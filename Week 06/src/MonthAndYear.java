import java.util.Scanner;

public class MonthAndYear {

	public static void main(String[] args) {
		System.out.print("Enter a number representing a month: ");
		Scanner input = new Scanner( System.in );
		int month = input.nextInt();
		
		switch (month)
		{
		case 2:
			System.out.print("Enter the year: ");
			int year = input.nextInt();
			
			if ((year % 400 == 0) ||
					((year % 4 == 0) && (year % 100 != 0)))
			{
				System.out.println("There were 29 days that month.");
			}
			else
			{
				System.out.println("There were 28 days that month.");
			}
			break;
			
		case 4:
			
		case 6:
			
		case 9:
			
		case 11:
			System.out.println("There were 30 days that month.");
			break;
			
		default:
			System.out.println("There were 31 days that month.");
			
		}

	}

}
