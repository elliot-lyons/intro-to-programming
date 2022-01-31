import java.util.Scanner;

public class PassOrFail {

	public static void main(String[] args) {
		System.out.println("Enter your result as number: ");
		Scanner input = new Scanner( System.in );
		double examPercentage = input.nextDouble();
		input.close();
		
		System.out.println("You " + (examPercentage >= 40 ? "passed." : ("failed.")));

	}

}
