/*  SELF ASSESSMENT of whether my code is easy to understand.
 
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:	10   
       Comment:	I believe all my variables could be understood easily by anyone reading my code. 
       
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:	5   
       Comment:	All variables start with a lower case letter and every word after that within the variable start with a capital letter
       and are not separated by symbols or spaces.
       
   3. Did I indent the code appropriately?
       Mark out of 15:	15
       Comment:	 All code is indented depending on how many { are before it, making it easier to read the if and else statements.
      
      Total Mark out of  30 (Add all the previous marks):	30  
*/


import java.util.Scanner; 

public class PlantClassifier {

	public static void main(String[] args) {
		System.out.print("Does the plant have cells and tissues which are organised into functional structures (Yes/No)?");
		Scanner input = new Scanner( System.in );
		String haveCellsAndTissuesAnswer = input.next();
		boolean haveCellsAndTissues = haveCellsAndTissuesAnswer.equalsIgnoreCase("Yes");
		
		if (haveCellsAndTissues)
		{
			System.out.print("Does the plant have vascular tissues (Yes/No)?");
			String haveVascularTissuesAnswer = input.next();
			boolean haveVascularTissues = haveVascularTissuesAnswer.equalsIgnoreCase("Yes");
			
			if (!haveVascularTissues)
			{
				System.out.println("The plant is a BRYOPHYTE.");
			}
			
			else
			{
				System.out.print("Is the plant dispersed by seeds (Yes/No)?");
				String dispersedBySeedsAnswer = input.next();
				boolean dispersedBySeeds = dispersedBySeedsAnswer.equalsIgnoreCase("Yes");
				
				if (!dispersedBySeeds)
				{
					System.out.println("The plant is a PTERIDOPHYTE.");
				}
				
				else
				{
					System.out.print("Are the seeds enclosed (Yes/No)?");
					String seedsEnclosedAnswer = input.next();
					boolean seedsEnclosed = seedsEnclosedAnswer.equalsIgnoreCase("Yes");
					
					if(!seedsEnclosed)
					{
						System.out.println("The plant is a GYMNOSPERM.");
					}
					
					else
					{
						System.out.println("The plant is an ANGIOSPERM.");
					}
					
				}
				
			}
			
		}
		
		else
		{
			System.out.println("The plant is an ALGAE.");
		}

	}

}
