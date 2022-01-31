import java.util.Scanner;

public class VertebrateClass {

	public static void main(String[] args) {
		System.out.print("Is the vertebrate cold blooded (Yes/No)? ");
		Scanner input = new Scanner( System.in );
		String isColdBloodedAnswer = input.next();
		boolean isColdBlooded = isColdBloodedAnswer.equalsIgnoreCase("Yes");
		
		if (isColdBlooded)
		{	
		System.out.print("Does the vertebrate have moist skin (Yes/No)? ");
		String hasMoistSkinAnswer = input.next();
		boolean hasMoistSkin = hasMoistSkinAnswer.equalsIgnoreCase("Yes");
		
		
				if (hasMoistSkin)
				{
					System.out.print("The vertebrate is classed as an amphibian.");
				}
		
				else
				{
					System.out.print("Does the vertebrate have fins (Yes/No)? ");
					String hasFinsAnswer = input.next();
					boolean hasFins = hasFinsAnswer.equalsIgnoreCase("Yes");	
		
				
					if (hasFins)
							{
								System.out.print("The vertebrate is classed as a fish.");
							}
						
					else
						{
							System.out.print("The vertebrate is classed as a reptile.");
						}
				}
		}
		
		else
		{
		System.out.print("Does the vertebrate have hair or fur (Yes/No)? ");
		String hasHairOrFurAnswer = input.next();
		boolean hasHairOrFur = hasHairOrFurAnswer.equalsIgnoreCase("Yes");
		input.close();
		
		
			if (hasHairOrFur)
			{
				System.out.print("The vertebrate is classed as a mammal.");
			}
			
			else
			{
				System.out.print("The vertebrate is classed as a bird.");
			}
		}
		
	
		
		
		
	}
}
