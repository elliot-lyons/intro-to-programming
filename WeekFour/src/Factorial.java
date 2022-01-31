import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
		System.out.print("Enter a positive whole number: ");
		Scanner input = new Scanner( System.in );
		int number = input.nextInt();
		
		int factorial = 1;
		for (int index=2; (index<=number); index = index + 1)
		{
			factorial = factorial * index;
		}
		
		
		// can be done by:
		// int factorial = 1;
		// int index = 2;
		// while (index <= number)
		// {
		// factorial = factorial * index;
		// index = index + 1;
		// }
		
		// or
		// int factorial = 1;
		// int index = 2;
		// while (index <= number)
		// factorial = factorial * index++;
		
		
		System.out.println("The factorial of " + number + " is " + factorial);
	}

}
