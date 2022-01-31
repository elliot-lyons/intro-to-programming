import java.util.Scanner;

public class Swap {

	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );
		
		System.out.println("Input a number: ");
		double numberA = input.nextDouble();
		
		System.out.println("Input another number: ");
		double numberB = input.nextDouble();
		
		numberA = numberA + numberB;
		numberB = numberA - numberB;
		numberA = numberA - numberB;
		
		System.out.println("NumberA = " + numberA);
		System.out.println("NumberB = " + numberB);
	}
}
