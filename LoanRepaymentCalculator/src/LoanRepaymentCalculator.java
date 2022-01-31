/*  SELF ASSESSMENT of whether my code is easy to understand.
 * 
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5:	5   
       Comment: Only needed one (MONTHS_PER_YEAR) and used it where applicable
   
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:	5
       Comment: Easy to recognize MONTHS_PER_YEAR = 12
   
   3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:	5
       Comment: Yes, declared MONTHS_PER_YEAR as final instead of monthsPerYear
       
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:   10
       Comment: I believe the variables used (loanTermYears, principalAmountOfLoan, 
       annualInterestRate, monthlyRepaymentRate, monthlyInterestRate, monthlyInterestRatePlusOne and
       loanTermYears) were self-explanatory 
         
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:	5  
       Comment: All began with a lower case letter and had an upper case letter for each new word after 
       that within the variable with no spaces or underscores between
       
   6. Did I indent the code appropriately?
       Mark out of 10:	10   
       Comment: All lines of code were indented depending on how many open brackets were before it
     
     Total Mark out of  40 (Add all the previous marks):	40  
*/


import java.util.Scanner;

public class LoanRepaymentCalculator {
	
	public static final double MONTHS_PER_YEAR = 12;
		
	public static void main(String[] args) {
		System.out.print("Enter loan amount? ");
		Scanner input = new Scanner ( System.in );
		double principalAmountOfLoan = input.nextDouble();
		
		System.out.print("Enter annual interest rate (e.g. 0.04)? ");
		double annualInterestRate = input.nextDouble();
		
		System.out.print("Enter the term of the loan in years? ");
		double loanTermYears = input.nextDouble();
		input.close();
		
		
		double monthlyInterestRate = (annualInterestRate / MONTHS_PER_YEAR);
		
		double monthlyInterestRatePlusOne = monthlyInterestRate + 1;
		
		double loanTermMonths = loanTermYears * MONTHS_PER_YEAR;
		
		
		
		double monthlyRepaymentRate = principalAmountOfLoan * 
				((monthlyInterestRate * (Math.pow(monthlyInterestRatePlusOne, loanTermMonths)))  
					/	(Math.pow(monthlyInterestRatePlusOne, loanTermMonths) - 1));
		
		
		System.out.printf("The monthly repayment for a %.0f "
				+ "year loan of %.2f at an annual interest rate of %.2f "
				+ "would be %.2f" 
				, loanTermYears , principalAmountOfLoan , annualInterestRate , monthlyRepaymentRate) ;
		
	}
	
}



