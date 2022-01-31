import java.util.Scanner;

public class Factorian {

	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );
		
		System.out.println("Enter in an integer seperated by spaces (e.g. 1 2 3): ");
		int integer = input.nextInt();
		int remainder = integer;
		input.close();
		int tenTest = integer;
		int tenToThePowerOfCount = 1;
		
		for (int tenCount = 0 ; tenTest >= 10; tenCount++)
		{
			tenTest = tenTest / 10;
			tenToThePowerOfCount = tenToThePowerOfCount * 10;
		}
		
			
		

	}

}
