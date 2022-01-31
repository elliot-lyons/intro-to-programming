/*  SELF ASSESSMENT of whether my code is easy to understand.
   
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5:	5   
       Comment:		Both variable names 'place' and 'exit' I feel are easy to interpret.

   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   5
       Comment: 	Both above variable names are formatted correctly.
   
   3. Did I indent the code appropriately?
       Mark out of 5:   5
       Comment: 	My code is indented as it should be and hence easier to understand.
   
   4. Did I implement a switch statement as required?
       Mark out of 10:   10
       Comment: 	I used a working switch statement as required.
   
       Total Mark out of  25 (Add all the previous marks):  
*/



import java.util.Scanner;

public class Prizes {

	public static void main(String[] args) {
		boolean exit = false;
		System.out.println("This program tells competition participants what prize they have won.");
		Scanner input = new Scanner ( System.in );
		
		do
		{
			System.out.print("Enter your place number (or type 'exit'): ");
			
			if (input.hasNextInt())
			{
				int place = input.nextInt();
				
				switch (place)
				{
				case 1:
					System.out.println("You came in 1st place and hence "
							+ "won two theatre tickets + drinks during the interval + dinner before the show.");
					break;
			
				case 2:
					System.out.println("You came in 2nd place and hence won two theatre tickets + drinks during the interval.");
					break;
			
				case 3:
					System.out.println("You came in 3rd place and hence won two theatre tickets.");
					break;
			
				case 4:
				
				case 5:
					System.out.printf("You came in %dth place and hence won a 10 Euro book token. %n", place);
					break;
			
				case 6:
				
				case 7:
				
				case 8:
				
				case 9:
				
				case 10:
					System.out.printf("You came in %dth place and hence won a 5 Euro book token. %n", place);
					break;
			
				default:
					System.out.println("Sorry.  You did not win a prize.");
				}
			}
				
			else if (input.hasNext("exit"))
				{
					exit = true;
				}
			
			else
			{
				System.out.println("Error");
				input.next();
			}
		
			
		} while (!exit);
		input.close();
	}
}
