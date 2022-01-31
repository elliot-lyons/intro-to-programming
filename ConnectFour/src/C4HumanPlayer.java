import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {
	private boolean error;
	private boolean quit;
	
	public C4HumanPlayer(int number)
	{
		super(number);
		error  = false;
		quit = false;
	}

	@Override
	public void askColumn()			// asks the player what column they wish to place their counter into
	{								// if they don't put in an integer they will be asked again
		do							// the main file also checks to see whether the integer passed in is a valid column. If it's not this function is called 
		{							// again
			if (error)
			{
				System.out.print("Error. ");
			}
			
			System.out.println("Choose a column to place your counter or type 'quit' to quit: ");
			Scanner input = new Scanner(System.in);
		
			if (input.hasNextInt())
			{
				int theInput = input.nextInt();
				setColumn(theInput);
				error = false;
			}
		
			else
			{
				if (input.hasNext("quit"))
				{
					quit = true;
				}
				error = true;
			}
		} while (error && !quit);
	}
	
	public boolean getQuit()
	{
		return quit;
	}
}
