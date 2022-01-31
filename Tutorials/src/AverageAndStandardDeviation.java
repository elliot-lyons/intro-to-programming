import java.util.Scanner;

public class AverageAndStandardDeviation {

	public static void main(String[] args) {
		System.out.print("Enter a number: ");
		Scanner input = new Scanner( System.in );
		double number1 = input.nextDouble();
		
		System.out.print("Enter another number: ");
		double number2 = input.nextDouble();
		
		System.out.print("Enter another number: ");
		double number3 = input.nextDouble();
		input.close();
		
		
		double sum = number1 + number2 + number3;
		double average = sum / 3;
		
		
		double standardDeviationSquared = ((((number1 - average) * (number1 - average)) + 
				((number2 - average) * (number2 - average)) + ((number3 - average)
						* (number3 - average))) / 3);
		// (Sum of (numberx - average)^2) divided by value of total numbers 
				
		double standardDeviation = Math.sqrt(standardDeviationSquared);
		
		
		System.out.println("Average is " + average);
		System.out.println("Standard deviation is " + standardDeviation);
				
				
				
				
	}

}
