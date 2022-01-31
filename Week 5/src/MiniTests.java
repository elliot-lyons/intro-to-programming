import java.util.Scanner;
public class MiniTests {

	public static void main(String[] args) {
		int number = 8;
		
boolean isPrimeNumber = true;
		
		if ( number <= 1 )
		{
			isPrimeNumber = false;
		}
		
		else
			{
			for 	( int divisor = number / 2; (divisor > 1) && (isPrimeNumber == true); divisor-- )
			{
				if (number % divisor == 0)
				{
					isPrimeNumber = false;
				}
			}
			}
	}
}
