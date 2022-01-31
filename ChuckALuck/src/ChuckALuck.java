/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object,
and a void return type [Mark out of 7: 7].
Comment: My resolveBet method follows all of the above definitions.

My program presents the amount of cash in the wallet and asks the user how much
he/she would like to bet [Mark out of 8: 8].
Comment: My program prints the amount of cash in the wallet 
and then asks the user how much they would like to bet.

My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: ]. 5 
Comment: My program checks whether the bet is lower than or equal to the amount in the wallet.
If not, the user can't play.

My program creates three Dice objects, rolls them and creates a total variable
with a summation of the roll values returned [Mark out of 15: 15]
Comment: My program does all of the above criteria.

My program determines the winnings by comparing the bet type with the total and
comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment: My program compare the bet with the total and dice faces, and determines the winnings based
on those factors.

My program outputs the results (win or loss) and adds the winnings to the wallet 
if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment: My program determines whether or not the player wins. If they do, the original bet is returned to 
the user's wallet and the winnings are also added. If they lose, the bet is not returned to their wallet.

2. Main

I ask the user for the amount of cash he/she has, 
create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: The user is asked how much is initially in their wallet. If they don't put in a valid figure, 
they are asked again.

My program loops continuously until the user either enters
quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment: The loop will continue until the above criteria are met.

I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: The program asks the user what bet they want to place. If they enter quit the program stops looping
around.

My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: My program calls on the resolveBet method and passes the betType and the player's wallet
as parameters.

At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment: Once the program stops looping, the program determines if the player has won or lost money.
It also determines if the player hasn't won or lost anything. It then prints this information out.

 Total Mark out of 100 (Add all the previous marks): 100
*/


import java.util.Scanner;

public class ChuckALuck {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean quit = false;
		boolean error = false;
		double initial = 0;
		String betType;
		
		do
		{
			if (error)
			{
				System.out.print("Error. ");
			}
			
			System.out.println("Welcome to the Chuck-A-Luck game."
						+ "You may choose one of four bets: "
						+ "Triple, Field, High or Low. "
						+ "Please enter the amount of cash you want to put in your wallet:");
		
			if (input.hasNextDouble())
			{
				initial = input.nextDouble();
				
				if (initial > 0)
				{
				error = false;
				}
				
				else
				{
					error = true;
				}
			}
			
			else
			{
				error = true;
			}
			
			input.nextLine();
		
		} while (error);
		
		Wallet theWallet = new Wallet();
		theWallet.addMoney(initial);
			
		do
		{
			if (!quit)
			{
				if (error)
				{
					System.out.print("Error. ");
				}
				
				System.out.println("Enter the type of bet you wish to place or 'quit': ");
					
				if (input.hasNext("quit"))
				{
					quit = true;
				}
					
				else
				{
					betType = input.next();
						
					if (betType.equalsIgnoreCase("triple") || betType.equalsIgnoreCase("field") || 
							betType.equalsIgnoreCase("high")|| betType.equalsIgnoreCase("low"))
					{
						resolveBet(betType, theWallet);
						error = false;
					}
						
					else 
					{
						error = true;
					}
					
				}
			} 
		} while (!quit && (theWallet.currentCash() > 0));
		
		if (quit || (theWallet.currentCash() <= 0))
		{
			double result = theWallet.result(initial);
			
			if (result > 0)
			{
				System.out.println("Congratulations! Overall, you won " + result + " dollars!");
			}
			
			if (result == 0)
			{
				System.out.println("You didn't make or lose any money.");
			}
			
			if (result < 0)
			{
				System.out.println("Hard luck! Overall, you lost " + (result * -1) + " dollars." );
			}
		}
			
	}

	public static void resolveBet(String bet, Wallet aWallet)
	{
		Scanner input = new Scanner(System.in);
		double money;
		boolean error = false;
		boolean win = false;
		int winMultiplier = 1;
		boolean triple = false;
	
		System.out.println(aWallet.cashToString());
			
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		Dice dice3 = new Dice();
			
		do
		{	
			if (error)
			{
				System.out.print("Error. ");
			}
				
			System.out.println("Enter the amount you wish to bet: ");
				
			if (input.hasNextDouble())
			{
				money = input.nextDouble();
					
				if (!aWallet.canPlay(money))
				{
					error = true;
				}
					
				else
				{
					error = false;
					aWallet.takeMoney(money);
							
					int dice1Side = dice1.roll();
					int dice2Side = dice2.roll();
					int dice3Side = dice3.roll();
					System.out.print("Dice 1 rolled: "+ dice1Side + ". Dice 2 rolled: " + dice2Side + ". Dice 3 rolled: " + dice3Side + ". ");
					int total = dice1Side + dice2Side + dice3Side;
						
					if ((dice1Side == dice2Side) && (dice1Side == dice3Side))
					{
						triple = true;
					}
							
					if (bet.equalsIgnoreCase("triple"))
					{
						if (triple && (dice1Side != 1) && (dice1Side != 6))
						{
							win = true;
							winMultiplier = 3;
						}
					}
						
					if (bet.equalsIgnoreCase("field"))
					{
						if (total < 8 || total > 12)
						{
							win = true;
						}
					}
						
					if (bet.equalsIgnoreCase("high"))
					{
						if (total > 10 && !triple)
						{
							win = true;
						}
					}
						
					if (bet.equalsIgnoreCase("low"))
					{
						if (total < 11 && !triple)
						{
							win = true;
						}
					}
					
					if (win)
					{
						double winnings = money + (money * winMultiplier);
						aWallet.addMoney(winnings);
						System.out.println("Congratulations! You have won " + (winnings - money) + " dollars.");
					}
					
					else
					{
						System.out.println("Hard luck! You lost " + money + " dollars.");
					}
				}
			}
				
			else 
			{
				error = true;
			}
						
				input.nextLine();
				System.out.println(aWallet.cashToString());
				
			} while (error);
	}
}