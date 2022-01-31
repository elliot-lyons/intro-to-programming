/* SELF ASSESSMENT

Connect4Game class (35 marks)
35
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: My program does this. My program first asks the number of players playing, creates a grid and starts the game. Each player may type quit should they
		 choose to do so. If not they input the column they wish to play. The program checks to see whether that column is an invalid column or the 
		 column is full. If either of these conditions are met they asked to enter in another column and will continue to be asked until they type in a
		 column that isn't full or a column that's valid. If the grid is full the game will terminate and the player won't be stuck in a loop where they
		 can't key in a valid column as all are full. Then the program checks whether the last counter caused a connect four. If it did, that player wins
		 and the program is terminated.

Connect4Grid interface (10 marks)
10
I define all 7 methods within this interface.
Comment: All the methods outlined are defined in this interface

Connect4Grid2DArray class (25 marks)
25 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: The class implements the Connect4Grid interface. As above all the appropriate checks are done to the last played piece in this class

ConnectPlayer abstract class (10 marks)
10
My class provides at least one non-abstract method and at least one abstract method. 
Comment: The class provides the abstract method askColumn and the non-abstract methods getColumn, setColumn and getPlayerNumber

C4HumanPlayer class (10 marks)
10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: My class does override the abstract methods and provides the functionality of a player to the user

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment: Again the abstract methods are overridden. It also has the functionality of an AI to play against the user 

Total Marks out of 100:
100
*/

import java.util.Scanner;

public class Connect4Game {
	
	public static void main(String[] args) {
		boolean error = false;
		int playerCount = 1;
		boolean aiWon = false;
		boolean quit = false;
		
		C4HumanPlayer playerOne = new C4HumanPlayer(1);
		C4HumanPlayer otherPlayer = new C4HumanPlayer(2);
		C4RandomAIPlayer playerTwo = new C4RandomAIPlayer(2);
		
		do				// this loops until the player count is either 1 or 2. It returns an error and asks how many player again if anything else is 
						// entered 
		{
			if (error)
			{
				System.out.print("Error. ");
			}
			
			else
			{
				System.out.print("Welcome to Connect 4. ");
			}
			
			System.out.println("Enter the number of players playing (1 or 2): ");
			
			Scanner input = new Scanner(System.in);
			
			if (input.hasNextInt())
			{
				playerCount = input.nextInt();
				
				if (playerCount < 1 || playerCount > 2)
				{
					error = true;
				}
				
				else
				{
					error = false;
				}
			}
			
			else
			{
				error = true;
			}
			
		} while (error);
		
		Connect4Grid2DArray grid = new Connect4Grid2DArray();		
		grid.emptyGrid();										// creating a new empty grid
		
		do														// this loop asks the first player where they want to place a counter. If the column is
		{														// full or invalid, it will continue to ask the player. It only stops if the board is full			
			boolean fullOrInvalid = false;						// or the player has input a valid column
			
			do
			{
				if (fullOrInvalid)
				{
					System.out.print("Error. ");
				}
				playerOne.askColumn();
				
				if (playerOne.getQuit())
				{
					quit = true;
				}
				
				if (!quit)
				{
					if (!grid.isValidColumn(playerOne.getColumn()) || grid.isColumnFull(playerOne.getColumn()))
					{
						fullOrInvalid = true;
					}
				
					else
					{
						fullOrInvalid = false;
					}
				}
				
			} while (!quit && fullOrInvalid && !grid.isGridFull());
			
			if (!fullOrInvalid && !quit)
			{
				grid.bottomRow(playerOne.getColumn());					// checking what the lowest available row is in the requested column
				grid.dropPiece(playerOne, playerOne.getColumn());		// 'dropping' the player's piece into that requested column
				System.out.print(grid.toString());						// prints out the grid with the latest piece dropped into it
				
				if (grid.didLastPieceConnect4())						// checking if that last piece has caused a connect four
				{
					System.out.println("'x' won.Congratulations!");		// if it has, it says that the player using 'x' has won and terminates the program
					break;
				}
			}
			
			fullOrInvalid = false;
			
			if (playerCount == 2 && !quit)
			{
				do							// exact same approach as above, if there is a second human player
				{
					if (fullOrInvalid)
					{
						System.out.print("Error. ");
					}
					otherPlayer.askColumn();
					
					if (otherPlayer.getQuit())
					{
						quit = true;
					}
					
					if (!quit)
					{
						if (!grid.isValidColumn(otherPlayer.getColumn()) || grid.isColumnFull(otherPlayer.getColumn()))
						{
							fullOrInvalid = true;
						}
					
						else
						{
							fullOrInvalid = false;
						}
					}
					
				} while (!quit && fullOrInvalid && !grid.isGridFull());
				
				if (!quit && !fullOrInvalid)
				{
					grid.bottomRow(otherPlayer.getColumn());
					grid.dropPiece(otherPlayer, otherPlayer.getColumn());
					System.out.print(grid.toString());
					if (grid.didLastPieceConnect4())
					{
						System.out.println("'y' won.Congratulations!");
						break;
					}
				}
			}
			
			else					// this is for the AI player
			{
				if (!quit)
				{
					boolean anError = true;
					
					while (anError && !grid.isGridFull())
					{
						playerTwo.askColumn();				// generates a random column 
					
						if (grid.isValidColumn(playerTwo.getColumn()) && !grid.isColumnFull(playerTwo.getColumn())); // checks if that column is full or invalid
						{
							anError = false;							// if column is valid and not full, the AI counter is put into the grid and checked to see 
							grid.bottomRow(playerTwo.getColumn());		// if that piece caused a connect four
							grid.dropPiece(playerTwo, playerTwo.getColumn());
							System.out.print(grid.toString());
						
							if (grid.didLastPieceConnect4())
							{
								System.out.println("Hard luck, you lost");		// if it did, it lets the human player know they've lost and the program is 
								aiWon = true;									// terminated
							}
						}
					}
				}
			}
		} while (!quit && !grid.isGridFull() && !aiWon);
		
		if (grid.isGridFull())
		{
			System.out.println("Game over. The grid is full, hence no one has won");		// if the grid gets full the program is terminated with this
		}																					// message
		
		if (quit)
		{
			System.out.println("Game over.");
		}
	}
}
