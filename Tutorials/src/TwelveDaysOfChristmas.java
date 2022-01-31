import java.util.Scanner;

public class TwelveDaysOfChristmas {

	public static void main(String[] args) {
		int count = 1;
		
		do
		{
			switch (count)
			{
			case 1: System.out.print("On the 1st day of Christmas my true love sent to me: ");
			break;
			
			case 2: System.out.print("On the 2nd day of Christmas my true love sent to me: ");
			break;
			
			case 3: System.out.print("On the 3rd day of Christmas my true love sent to me: ");
			break;
			
			case 4:
				
			case 5:
				
			case 6:
				
			case 7: 
				
			case 8:
				
			case 9:
				
			case 10:
			
			case 11: 
			
			case 12: System.out.printf("On the %dth day of Christmas my true love sent to me: %n" , count);
			}
			
			switch (count)
			{
			case 12: System.out.printf("12 drummers drumming, %n");
			
			case 11: System.out.printf("11 pipers piping, %n");
			
			case 10: System.out.printf("10 lords a-leaping, %n");
			
			case 9: System.out.printf("9 ladies dancing, %n");
			
			case 8: System.out.printf("8 maids a-milking, %n");
			
			case 7: System.out.printf("7 swans a-swimming, %n");
			
			case 6: System.out.printf("6 geese a-laying, %n");
			
			case 5: System.out.printf("5 golden rings, %n");
			
			case 4: System.out.printf("4 calling birds, %n");
			
			case 3: System.out.printf("3 french hens, %n");
			
			case 2: System.out.printf("2 turtle doves and %n");
			
			case 1: System.out.printf("a partridge in a pear tree %n %n");
			}
			
			count = count + 1;
		
		} while (count < 13);
		
	}

}
