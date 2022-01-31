import java.util.Scanner;

public class TriangleArea {

	public static void main(String[] args) {
		System.out.print("Enter the x co-ordinate for vertex A: ");
		Scanner input = new Scanner( System.in );
		double xA = input.nextDouble();
		
		System.out.print("Enter the y co-ordinate for vertex A: ");
		double yA = input.nextDouble();
		
		
		System.out.print("Enter the x co-ordinate for vertex B: ");
		double xB = input.nextDouble();
		
		System.out.print("Enter the y co-ordinate for vertex B: ");
		double yB = input.nextDouble();
		
		
		System.out.print("Enter the x co-ordinate for vertex C: ");
		double xC = input.nextDouble();
		
		System.out.print("Enter the y co-ordinate for vertex C: ");
		double yC = input.nextDouble();
		input.close();
		
		
		double xaTimesYbMinusYc = xA * (yB - yC);
		
		double xbTimesYcMinusYa = xB * (yC - yA);
		
		double xcTimesYaMinusYb = xC * (yA - yB);
		
		double area = Math.abs((xaTimesYbMinusYc + xbTimesYcMinusYa + xcTimesYaMinusYb) / 2);
		
		
		System.out.println("The area of triangle ABC is: " + area);
		
		
	}
}
