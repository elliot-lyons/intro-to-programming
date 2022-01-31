import java.util.Scanner;

public class IsAdult {

	public static void main(String[] args) {
		System.out.print("Enter your age? ");
		Scanner input = new Scanner ( System.in );
		int age = input.nextInt();
		input.close();
		
		boolean isAdult = (age >= 18);
		
		if (isAdult)
		{
			System.out.println("You may now legally drink!");
		}
	}
}
