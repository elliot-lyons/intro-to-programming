import java.util.Scanner;

public class AverageMark {
	
	public static final double NUMBER_OF_MARKS = 5;

	public static void main(String[] args) {
		int index = 0;
		double[] marks = new double[5];
		
		System.out.println("Enter the 5 percentages obtained: ");
		Scanner input = new Scanner( System.in );
		
		while ( index < NUMBER_OF_MARKS )
		{
			marks[index] = input.nextDouble();
			index++;
		}
		
		double average = determineAverageMark( marks );
		int count = countAboveAverageStudents( marks );
		
		System.out.print("The average percentage is " + average + "% and there " + (count == 1 ? 
				"was " : "were ") + "only " + count + " above avearge " + (count == 1 ? 
						"student." : "students.")  );
		input.close();
		
	}

	public static double determineAverageMark( double[] marks )
	{
		double sumOfMarks = 0;
		int index = 0;
		
		while ( index < NUMBER_OF_MARKS )
		{
			sumOfMarks = sumOfMarks + marks[index];
			index++;
		}
		
		return sumOfMarks / NUMBER_OF_MARKS;
	}
	
	public static int countAboveAverageStudents( double[] marks )
	{
		double average = determineAverageMark( marks );
		int index = 0;
		int count = 0;
		
		while ( index < NUMBER_OF_MARKS )
		{
			double currentMark = marks[index];
			
			if ( currentMark > average )
			{
				count++;
			}
			
			index++;
		}
		
		return count;
	}
}
