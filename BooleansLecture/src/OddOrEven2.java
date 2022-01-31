import java.util.Scanner;

public class OddOrEven2 {

	public static void main(String[] args) {
		System.out.println("Enter a number: ");
		Scanner input = new Scanner( System.in );
		int number = input.nextInt();
		input.close();
		
		System.out.println("Number is " + (number%2 == 1 ? " odd." : (" even.")));

	}

}
