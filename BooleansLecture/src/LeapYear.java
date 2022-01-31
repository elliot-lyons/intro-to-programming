import java.util.Scanner;
	
public class	LeapYear	{

	public static void	main(String[]	args)	{
				System.out.print("Enter the year? ");	
				Scanner	input	=	new	Scanner( System.in );	
				int	year	=	input.nextInt();
				input.close();
				
				boolean	isLeapYear	=	((year	%	400	==	0)	||	
				(!(year	%	100	==	0)	&&	(year	%	4	==	0)));	
				if	(isLeapYear)

					System.out.print("Year"	+ year +" is a leap	year.");	
			else	System.out.print("Year " +  year + " is not	a leap year.");		
		}
}
