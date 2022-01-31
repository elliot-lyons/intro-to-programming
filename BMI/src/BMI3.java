import java.util.Scanner;

public class BMI3 {
	
	public static final double MIN_NORMAL_BMI = 18.5;
	public static final double MIN_OVERWEIGHT_BMI = 25.0;
	public static final double MIN_OBESE_BMI = 30.0;

	public static void main(String[] args) {
		
		System.out.print("What is your weight in kg? ");
		Scanner input = new Scanner( System.in );
		double weight = input.nextDouble();
		
		System.out.print("What is your height in metres? ");
		double height = input.nextDouble();
		input.close();
		
		double hsquared = height * height;
		double BMI = weight / hsquared;
		
		String	weightClassification	=	"Normal";	
		if	(BMI	<	MIN_NORMAL_BMI)	
		{	
		weightClassification	=	"Underweight";	
		}	
		else if	((BMI	>=	MIN_OVERWEIGHT_BMI)	&&
					(BMI	<	MIN_OBESE_BMI))	
		{	
		weightClassification	=	"Overweight";	
		}	
		else	if	(BMI	>=	MIN_OBESE_BMI)
		{	
		weightClassification	=	"Obese";	
		}
		System.out.println("Your BMI is "	+	BMI	+	
		" which is classified as " + weightClassification);
		
	}
}



