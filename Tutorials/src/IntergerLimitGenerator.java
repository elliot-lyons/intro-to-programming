import java.util.Scanner;

public class IntergerLimitGenerator {
	public static void main(String args[]) {
		
		System.out.print("Enter the a positive interger multiple: ");
		Scanner input = new Scanner( System.in);
		int multiple = input.nextInt();
		
		System.out.print("Enter a positive interger limit: ");
		int limit = input.nextInt();
		
		if (limit < 1)
		{
			System.out.println("This program can't compute values less than 1");
		}
		
		else
		{
			System.out.println("The multiples of " + multiple + " (up to " + limit + ") are ");
					
			for (int currentMultiple=0; (currentMultiple <= limit); currentMultiple = currentMultiple + multiple )
			
			System.out.println(((currentMultiple>0)?", ":"") + currentMultiple);
			
		}

	}
}
